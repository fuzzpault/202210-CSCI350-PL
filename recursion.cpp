/*
	recursion.cpp

	Paul Talaga
	Oct 19, 2022

	Different ways of using recursion to sum the values in a
	vector.
*/

#include <iostream>
#include <vector>
#include <time.h>
#include <chrono>

using namespace std;

// We are doing a bad thing and using a global variable numbers.
// This simplifies the recursive call for most functions
// as we're just changing the index.
vector<int> numbers;

// Non-tail recursive version that recurses to change the 
// index value.
unsigned long sum(int index){
	if(index == 0){
		return numbers[index];
	}else{
		return sum(index - 1) + numbers[index];
	}
}

// Tail-recursive version of the above function.
// Note the result parameter passes the sum so far down
// until the base case returns the final result.
unsigned long sum2(int index, unsigned long result){
	if(index == 0){
		return result + numbers[0];
	}else{
		return sum2(index-1, result + numbers[index]);
	}
}

// Similar to above, but pass the full vector
// Note this vector is pass-by-value, so a copy needs to
// be made for each recursive call.
unsigned long sum3(vector<int> v){
	if( v.size() == 1)return v[0];
	int first = v[0];
	v.erase(v.begin()); // https://www.tutorialkart.com/cpp/cpp-vector-remove-first-element/
	return first + sum3(v);
}

int main(){
	unsigned long sum_actual = 0;
	for(unsigned i = 0; i < 100000; i++){
		unsigned r = rand() % 1000000;
		sum_actual += r;
		numbers.push_back(r);
	}

	cout << "Actual sum: " << sum_actual << endl;

	// Just recursing on the index & using 
	// a global variable(vector)
	clock_t start = clock();
	auto now   = std::chrono::high_resolution_clock::now();
	cout << "sum:  " << sum(numbers.size() - 1) << endl;
	clock_t stop = clock();
	auto then   = std::chrono::high_resolution_clock::now();
	cout << "  Elapsed: " << 
		std::chrono::duration_cast<std::chrono::milliseconds>(then-now).count() << endl;


	start = clock();
	cout << "sum2: " << sum2(numbers.size() - 1, 0) << endl;
	stop = clock();
	cout << "  Elapsed: " << (stop - start) / CLOCKS_PER_SEC << endl;

	start = clock();
	cout << "sum3: " << sum3(numbers) << endl;
	stop = clock();
	cout << "  Elapsed: " << (stop - start) / CLOCKS_PER_SEC << endl;


	
}