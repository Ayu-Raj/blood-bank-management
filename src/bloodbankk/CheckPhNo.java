/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

/**
 *
 * @author ayush
 */
public class CheckPhNo {
    int checkPh(long n){
        int Count=0;
    while(n > 0) {
			n = n / 10;
			Count = Count + 1; 
		}
    if(Count==10){
    return 1;}
    else{
    return 0;}
    }
}
