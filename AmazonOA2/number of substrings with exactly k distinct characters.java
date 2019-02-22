import java.util.Arrays; 
  
public class CountKSubStr 
{ 
    int countkDist(String str, int k) 
    { 
        int res = 0; 
        int n = str.length();  
        int cnt[] = new int[26]; 
        for (int i = 0; i < n; i++) 
        { 
            int dist_count = 0; 
            Arrays.fill(cnt, 0); 
            for (int j=i; j<n; j++) 
            { 
                // If this is a new character for this 
                // substring, increment dist_count. 
                if (cnt[str.charAt(j) - 'a'] == 0) 
                    dist_count++; 
  
                // Increment count of current character 
                cnt[str.charAt(j) - 'a']++; 
                if (dist_count == k) 
                    res++; 
            } 
        } 
  
        return res; 
    } 
  
    // Driver Program 
    public static void main(String[] args) 
    { 
        CountKSubStr ob = new CountKSubStr(); 
        String ch = "abcbaa"; 
        int k = 3; 
        System.out.println("Total substrings with exactly " + 
                           k +    " distinct characters : "
                           + ob.countkDist(ch, k)); 
    } 
} 