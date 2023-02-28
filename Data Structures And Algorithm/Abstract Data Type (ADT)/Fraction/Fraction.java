class Fraction implements FractionI 
{
    private int numer;
    private int denom;
    
    public Fraction() 
    { 
        this(1,1) ; 
    }
    
    public Fraction(int numer, int denom) 
    {
        setNumer(numer);
        setDenom(denom);
    }
    
    @Override
    public int getNumer() 
    {
        return this.numer ;
    }
    
    @Override
    public int getDenom() 
    { 
        return this.denom ;
    }
    
    @Override
    public void setNumer(int numer) 
    { 
        this.numer = numer ;
    }
    
    @Override
    public void setDenom(int denom) 
    { 
        this.denom = denom ;
    }
    
    @Override
    public FractionI add(FractionI f) 
    {
        FractionI f2 = new Fraction();   // da hinh qua interface. Dau co tao doi tuong cua Interface dau
        
        f2.setNumer(this.numer * f.getDenom() + this.denom * f.getNumer()) ;      
        f2.setDenom(this.denom * f.getDenom()) ;  
        
        return f2;
    }
    
    @Override
    public FractionI minus(FractionI f)
    {
        FractionI f2 = new Fraction();   // da hinh qua interface. Dau co tao doi tuong cua Interface dau
        
        f2.setNumer(this.numer * f.getDenom() - this.denom * f.getNumer()) ;      
        f2.setDenom(this.denom * f.getDenom()) ;  
        
        return f2;
    }

    @Override
    public FractionI times(FractionI f)
    {
        FractionI f2 = new Fraction();   // da hinh qua interface. Dau co tao doi tuong cua Interface dau
        
        f2.setNumer(this.numer * f.getNumer()) ;      
        f2.setDenom(this.denom * f.getDenom()) ;  
        
        return f2;
    }

    private int gcd(int a, int b)   // tim ucln
    {
        int min ;

        if(a<=b)    min = a ;
        else        min = b ;

        for(int i = min ; i>=2 ; i--)
            if(a%i==0 && b%i==0)
                return i ;
        
        return 1 ;
    }
    
    @Override
    public FractionI simplify() 
    { 
        int c = gcd(this.numer, this.denom) ;

        this.numer = this.numer / c ;
        this.denom = this.denom / c ;

        return new Fraction(this.numer, this.denom) ;   // da hinh qua interface. Dau co tao doi tuong cua Interface dau
    }
    
    public String toString() 
    {
        return this.numer + "/" + this.denom ;
    }

    public boolean equals(FractionI f)
    {
        if(this.numer == f.getNumer() && this.denom == f.getDenom())    return true ;
        
        return false ;
    }
}