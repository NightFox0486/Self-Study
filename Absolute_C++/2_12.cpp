#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(){
    string text;
    fstream inputStream;

    inputStream.open("Absolute_C++\\player.txt");

    while(inputStream >> text){
        cout << text << endl;
    }
    inputStream.close();

    return 0;
}