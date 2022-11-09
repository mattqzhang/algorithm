/**
lc 636

On a single threaded CPU, we execute some functions.
Each function has a unique id between 0 and N-1.
We store logs in timestamp order that describe when a function is entered or exited.
Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".
For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.
"1:end:2" means the function with id 1 ended at the end of timestamp 2.
A function's exclusive time is the number of units of time spent in this function.
Note that this does not include any recursive calls to child functions.
The CPU is single threaded which means that only one function is being executed at a given time unit.
Return the exclusive time of each function, sorted by their function id.
*/

    public int[] exclusiveTime(int n, List<String> logs) {
        // time spent for each job
        int time[] = new int[n];

        Stack < Integer > st = new Stack < > ();
        String[] s = logs.get(0).split(":");
        // stack to save the id of jobs in execution so far
        st.push(Integer.parseInt(s[0]));
        // the start time of the job currently running
        int currStart = Integer.parseInt(s[2]);

        for(int i=1; i< logs.size(); i++){
            s = logs.get(i).split(":");
            // a new job
            if(s[1].equals("start")){
                // compute the execution time of the current job so far
                if(!st.empty())
                    time[st.peek()] += Integer.parseInt(s[2]) - currStart;
                // push the new job id into stack
                st.push(Integer.parseInt(s[0]));
                // record the new job's starting time as current job
                currStart = Integer.parseInt(s[2]);
            }else { // end of a job
                // compute running time of current job
                time[st.peek()] += Integer.parseInt(s[2])- currStart + 1;
                // pop the job in the stack to be currrent, and record the start time
                st.pop();
                currStart = Integer.parseInt(s[2]) + 1;
            }
        }
        return time;
    }
