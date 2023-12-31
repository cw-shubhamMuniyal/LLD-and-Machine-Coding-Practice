using Model;

namespace Logic
{
    public class UserService
    {
        List<User> Users {get;} = new List<User>();
        public void AddUser(User user)
        {
            Users.Add(user);
        }
        public List<User> GetAllUsers()
        {
            return Users;
        }
    }
}