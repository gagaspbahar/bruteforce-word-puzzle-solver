#include "readfile.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int split(string s, char limit, char *puzzle){
    int j = 0;
    for(int i = 0; i < (int)s.size(); i++){
        if(s[i] != limit){
            puzzle[i][j] = s[i]; 
        }
    }
}

int readFromFile(string filename){
    char puzzle[100][100] = {};
    
    ifstream file(filename);
    string line;
    while(getline(file, line)){
        
    }
}