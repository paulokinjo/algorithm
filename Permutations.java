class Permutations {
    public static void main(String args[] ) throws Exception {
      permutations("", "ABC");        
    }

    public static void permutations(String prefix, String suffix) {
        if(suffix.length() == 0) System.out.println(prefix);
        else {
            for(int i = 0; i < suffix.length(); i++) {
                String p = prefix + suffix.charAt(i);
                String s = suffix.substring(0, i) + suffix.substring(i + 1, suffix.length());
                permutations(p, s);
            }
        }
    }
}
