//public class   public class AnagramHelper
//{
//    private string A { get; set; }
//    private string B { get; set; }
//
//    public AnagramHelper(string a, string b)
//    {
//        A = a;
//        B = b;
//    }
//
//    private bool IsAnagram()
//    {
//        if (A.Length != B.Length)
//            return false;
//
//        if (A == B)
//            return true;
//
//        return A.OrderBy(c => c).SequenceEqual(B.OrderBy(c => c));
//    }
//
//    private HashSet<string> GeneratePartialPermutation(string word)
//    {
//        return new HashSet<string>(Enumerable.Range(0, word.Length)
//                .Select(i => word.Remove(i, 1).Insert(0, word[i].ToString())));
//    }
//
//    private IEnumerable<string> GeneratePermutation(string a)
//    {
//
//        HashSet<string> perms = GeneratePartialPermutation(a);
//        Enumerable.Range(0, 2).ToList().ForEach(c =>
//                {
//                        Enumerable.Range(0, perms.Count())
//                                .ToList()
//                                .ForEach
//                                        (
//                                                i => GeneratePartialPermutation(
//                                perms.ElementAt(i))
//                                .ToList()
//                                .ForEach(p => perms.Add(p))
//                );
//
//        Enumerable.Range(0, perms.Count())
//                .ToList()
//                .ForEach
//                        (
//                                i => GeneratePartialPermutation(new String
//                (perms.ElementAt(i).ToCharArray()
//                        .Reverse().ToArray())
//        )
//                .ToList().ForEach(p => perms.Add(p)));
//            });
//
//        return perms.Where(p => !p.StartsWith("0")).OrderBy(p => p);
//    }
//
//    public IEnumerable<string> GetResults()
//    {
//        if (IsAnagram())
//            return GeneratePermutation(A);
//        else
//            return GeneratePermutation(B);
//    }
//}Anagrams {
//}
