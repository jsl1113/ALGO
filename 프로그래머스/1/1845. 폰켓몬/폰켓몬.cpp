#include <string>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

int solution(vector<int> nums) {
    int size = nums.size() / 2; // 꺼낼 개수 3
    sort(nums.begin(), nums.end());
    nums.erase(unique(nums.begin(), nums.end()), nums.end()); 
    return size < nums.size() ? size : nums.size();
}