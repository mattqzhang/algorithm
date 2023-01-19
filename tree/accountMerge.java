/*
Given a list accounts, each element accounts[i] is a list of strings, where the first element
accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person
if there is some email that is common to both accounts. Note that even if two accounts have the same name,
they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account
is the name, and the rest of the elements are emails in sorted order. The accounts themselves
can be returned in any order.

lc 721
https://leetcode.com/problems/accounts-merge/
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> email2Name = new HashMap<>();
        HashMap<String, HashSet<String>> emailGraph = new HashMap<>();

        // construct graph        
        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i=1; i<account.size(); i++){
                if (!emailGraph.containsKey(account.get(i))) {
                    emailGraph.put(account.get(i), new HashSet<String>());
                }
                // email at account(1) has link to all later emails
                emailGraph.get(account.get(1)).add(account.get(i));
                // other emails have link to accout(1)
                emailGraph.get(account.get(i)).add(account.get(1));
                // each email is connected to nmae
                email2Name.put(account.get(i), name);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for(String email : emailGraph.keySet()){
            // bfs from each un-visited node
            if(!visited.contains(email)){
                visited.add(email);
                // bfs queue
                Queue<String> qe = new LinkedList<>();
                qe.offer(email);
                // connected email list from the popped node
                List<String> emailList = new ArrayList<>();
                while(!qe.isEmpty()){
                    String node = qe.poll();
                    emailList.add(node);
                    // loop through all connected neighbors of this node
                    for(String nb : emailGraph.get(node)){
                        if(!visited.contains(nb)) {
                            visited.add(nb);
                            qe.offer(nb);
                        }
                    }
                }
                Collections.sort(emailList);
                // add name as 1st in list
                emailList.add(0, email2Name.get(email));
                res.add(emailList);
            }
        }
        return res;        
    }
}
