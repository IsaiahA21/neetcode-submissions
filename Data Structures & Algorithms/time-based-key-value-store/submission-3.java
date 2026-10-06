/**
we are search for ele <= target. binary search.
no remove operation so we can keep it sorted.
if ele != target, we get the closet element. which is the mid value if we didnt find the exact.

if ele != target
**/


class TimeMap {

    Map<String, List< List<Object> >> map; // Object List => [val, time]

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Object> val_time = List.of(value, timestamp);
        
        if (!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        List<List<Object>> vals = map.get(key);
        vals.add(val_time);

        // vals.forEach(val -> System.out.println(val.get(0) + " " + val.get(1)));

    }
    
    public String get(String key, int timestamp) {
        // now when we call get we need to perform binary search on timestamp

        if (!map.containsKey(key) || map.get(key).isEmpty() ){
            return "";
        }

        List<List<Object>> vals = map.get(key);
        int n = vals.size();

        int lptr =0;
        int rptr = n -1;

        int mid = 0;

        // List<Object> val_time_mid =  vals.get(0);

        while (lptr <= rptr){
            mid = lptr + (rptr - lptr) / 2;

            List<Object> val_time_mid = vals.get(mid);
            // List<Object> val_time_left = vals.get(lptr);
            // List<Object> val_time_right = vals.get(rptr);

            if ((int)val_time_mid.get(1) == timestamp) return (String) val_time_mid.get(0);

            if (timestamp > (int)val_time_mid.get(1) ) lptr = mid + 1;
            else{
                rptr = mid - 1;
            }

        }

        // rptr = last timestamp <= target
        if (rptr < 0) {
            return "";
        }
        // else the closes is where the mid ptr is
        
        return (String) vals.get(rptr).get(0);
    }
}
