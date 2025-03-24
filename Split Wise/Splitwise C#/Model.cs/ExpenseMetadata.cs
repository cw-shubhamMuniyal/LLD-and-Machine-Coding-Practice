namespace Model
{
    public class ExpenseMetadata
    {
        public string Name { get; set; }
        public string ImgUrl { get; set; }
        public string Notes { get; set; }
        public ExpenseMetadata(string name, string imgUrl, string notes)
        {
            this.Name = name;
            this.ImgUrl = imgUrl;
            this.Notes = notes;
        }
    }
}