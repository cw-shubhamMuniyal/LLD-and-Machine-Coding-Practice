namespace Model
{
    public class BalanceSheet
    {
        public Dictionary<string, List<Split>> SplitsByUser {get;} = new Dictionary<string, List<Split>>();
        public void Initialize(List<string> ids)
        {
            foreach(string id in ids)
            {
                SplitsByUser.Add(id, new List<Split>());
            }
        }
    }
}