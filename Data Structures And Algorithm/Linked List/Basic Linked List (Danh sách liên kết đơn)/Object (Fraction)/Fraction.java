public class Fraction
{
    // properties
    private int tu ;
    private int mau ;

    // constructors
    public Fraction()
    {
        this.tu = 0 ;
        this.mau = 1 ;
    }

    public Fraction(int tu, int mau)
    {
        this.tu = tu ;
        this.mau = mau ;
    }
    
    // getters
    public int getTu()
    {
        return this.tu ;
    }

    public int getMau()
    {
        return this.mau ;
    }

    // setters
    public void setTu(int tu)
    {
        this.tu = tu ;
    }

    public void setMau(int mau)
    {
        this.mau = mau ;
    }

    // methods
    public double getFractionValue() 
    {
        return this.tu/(this.mau*1.0) ;
    }

    public void setFractionValue(Fraction a)
    {
        this.tu = a.tu ;
        this.mau = a.mau ;
    }

    public String toString()
    {
        return this.tu + "/" + this.mau ;
    }
}