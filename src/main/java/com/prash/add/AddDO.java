package com.prash.add;

public class AddDO {
 int param1;
 int param2;
 int result;

 public AddDO(int p1, int p2, int r) {
     param1=p1;param2=p2;result=r;
 }


public int getParam1() { return param1;}
public int getParam2() { return param2;}
public int getResult() { return result;}

public void setParam1(int p) {param1=p;}
public void setParam2(int p) {param2=p;}
public void setResult(int p) {result=p;}

}