using Logic;

namespace Rate_Limiter;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
        UserBucketCreator userBucketCreator = new UserBucketCreator("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
        userBucketCreator.GrantApplication("10");
    }
}
