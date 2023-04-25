/*
 Given an address book, where each entry consists of a name and a list of email addresses.
 Remove duplicates and return merged contacts.
 Two contacts are considered to be the same, if they share at least one email address.

Given:
"Al Work" -> ["Al@apple.com"]
"Al" -> ["Al@iCloud.com"]
"Bob" -> ["Bob@apple.com"]
"Al Home" -> ["AlexHome@iCloud.com", "Al@iCloud.com", "Al@apple.com"]
"Robert" -> ["Robert@iCloud.com", "Bob@apple.com"]
"Cam" -> ["cam@apple.com"]

Return:
[["Al Work", "Al", "Al Home”], ["Bob", "Robert"], ["Cam"]]

 */

/*
Solution 1: Similar idea as account merge, but more complicate.
step 1: get
    map of <email, name set>,
    graph map of: <email, <list of email neighbor>>>
step 2: bfs on graph, get equivalent set of list<set<email>>
step 3: for each set<email>, get set<name>, combined into list<list<name>>, and return
*/

    // input: Arraylist<ArrayList<String>>
    // output: List<List<String>>
    public List<List<String>> mergeContacts(ArrayList<ArrayList<String>> addresses) {
        // map of <email, <name set>>
        HashMap<String, HashSet<String>> email_names = new HashMap<>();
        // map of <email, email neighbor list>
        HashMap<String, ArrayList<String>> email_graph = new HashMap<>();

        // step 1: parse input, and initialization maps
        for (ArrayList<String> entry : addresses) {
            String name = entry.get(0);
            for (int i=1; i<entry.size(); i++) {
                String curEmail = entry.get(i);
                // map of <email, <name set>>
                HashSet<String> names = email_names.getOrDefault(curEmail, new HashSet<String>());
                names.add(name);
                email_names.put(curEmail, names);

                // graph map of: <email, <list of neighbor>>
                // add first email to i-th's neighbor
                ArrayList<String> neighbors = email_graph.getOrDefault(curEmail, new ArrayList<String>());
                neighbors.add(entry.get(1));
                email_graph.put(curEmail, neighbors);
                // add to first email's neibhgor
                email_graph.get(entry.get(1)).add(curEmail);
            }
        }

        // step 2: bfs on graph, get equivalent email set list<set<email>>
        HashSet<String> visited = new HashSet<>();
        List<Set<String>> equalEmails = new LinkedList<>();
        for (String email : email_graph.keySet()) {
            if (visited.contains(email))
                continue;

            Set<String> emailSet = new HashSet<>();
            // bfs from this email
            Queue<String> qe = new LinkedList<String>();
            qe.offer(email);
            while (!qe.isEmpty()) {
                String cur = qe.poll();
                emailSet.add(cur);
                for (String nei : email_graph.get(cur)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        qe.offer(nei);
                    }
                }
            }
            equalEmails.add(emailSet);
        }

        // Step 3:
        // for each set<email>, get set<name>, combined into list<list<name>>, and return
        List<List<String>> equalNames = new LinkedList<>();
        Set<String> sameNames = new HashSet<>();
        for (Set<String> emailSet : equalEmails) {
            Set<String> nameSet = new HashSet<>();
            for (String email : emailSet) {
                Set<String> names = email_names.get(email);
                sameNames.addAll(names);
            }
            List<String> sameNamesList = new LinkedList<>(sameNames);
            equalNames.add(sameNamesList);
        }

        return equalNames;
    }

/*
    Solution 2: A simpler approach
    step 1:
       for all <name, <emails>>, build edge from name to each email, and from email to names,
       output HashMap<String, Set<String>>
    step 2:
      bfs for all {name, email} that are connected, put in the same set,
      output List<Set<String>>
    Step 3:
      for each Set<String>, remove emails (strings with '@')
 */
    public List<List<String>> mergeContacts_v2(ArrayList<ArrayList<String>> addresses) {
        // step 1:
        HashMap<String, HashSet<String>> edges = new HashMap<>();
        for (List<String> entry : addresses) {
            String name = entry.get(0);
            HashSet<String> email_nb = edges.getOrDefault(name, new HashSet<String>());
            for (int i=1; i<entry.size(); i++) {
                // name to emails
                email_nb.add(entry.get(i));
                edges.put(name, email_nb);
                // email to names
                HashSet<String> name_nb = edges.getOrDefault(entry.get(i), new HashSet<String>());
                name_nb.add(name);
                edges.put(entry.get(i), name_nb);
            }
        }

        // step 2:
        HashSet<String> visited = new HashSet<>();
        List<Set<String>> sameAccounts = new LinkedList<>();
        for (String node : edges.keySet()) {
            // for each node, find all connected acconts
            if (visited.contains(node))
                continue;

            visited.add(node);
            HashSet<String> samePerson = new HashSet<>();
            Queue<String> qe = new LinkedList<>();
            qe.offer(node);
            while (!qe.isEmpty()) {
                String cur = qe.poll();
                samePerson.add(cur);
                for (String nei : edges.get(cur)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        qe.offer(nei);
                    }
                }
            }
            sameAccounts.add(samePerson);
        }

        // step 3:
        List<List<String>> sameNames = new LinkedList<>();
        for (Set<String> same : sameAccounts) {  // mix of emails and names
            List<String> sameName = new LinkedList<>();
            for (String item : same) {
                if (!item.contains("@")) {
                    sameName.add(item);
                }
            }
            sameNames.add(sameName);
        }
        return sameNames;
    }

