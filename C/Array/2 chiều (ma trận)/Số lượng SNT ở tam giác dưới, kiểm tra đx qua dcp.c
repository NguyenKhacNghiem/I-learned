int demSoLuongSNTrenTamGiacDuoi(int a[][100], int m, int n)
{
    int count = 0 ;

    if(m != n) // khong phai ma tran vuong 
        return count ;

    int i, j ;
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			if(i>=j)
				if(kiemTraSNT(a[i][j])) 
                    count++;
                    
	return count;
}

bool kiemTraDoiXungQuaDuongCheoPhu(int a[][100], int m, int n)
{
    if(m != n) // khong phai ma tran vuong 
        return false ;
    
    int i, j ;

	for(i=0;i<n;i++)
		for (j=0;j<n;j++)
			if(a[i][j] != a[n-1-j][n-1-i])
				return false;
		
	return true;
}




