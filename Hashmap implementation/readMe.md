## key points:

- Bucket: It is a LinkedList structure of nodes at every index of array.
- hash code on same object gives same value every time.
- hash code on different object may or may not gives same value.
- if 2 objects are equal (using equals function of object class), then their hash code will be same.
- if 2 objects are not equal (using equals function of object class), then their hash code may or may not be same.
- if load factor becomes 75%, then re-size will happen.
Eg: if current capacity is 2^5 (32) and 32 * 0.75 (~24) capacity is utilized, then it capacity will increase to 2^6 (64).
- After resizing, rehash will happen. Rehashing is basically to distribute all elements based on new capacity to ensure all buckets are utilised equally.