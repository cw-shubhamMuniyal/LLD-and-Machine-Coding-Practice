namespace Model
{
    public class User
    {
        public string Id {get;set; }
        public string Name {get;set; }
        public string PhoneNumber {get;set; }
        public string Email {get;set; }
        public User(string id, string name, string phoneNumber, string email)
        {
            this.Name = name;
            this.Id = id;
            this.Email = email;
            this.PhoneNumber = phoneNumber;
        }

    }
}