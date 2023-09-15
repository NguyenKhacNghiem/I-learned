public class SoPhuc
{
    private double thuc ;
    private double ao ;
    // cau a
    public SoPhuc()
    {
        this.thuc = 0 ;
        this.ao = 0 ;
    }
    public SoPhuc(double thuc)
    {
        this.thuc = thuc ;
        this.ao = 0 ;
    }
    public SoPhuc(double thuc, double ao)
    {
        this.thuc = thuc ;
        this.ao = ao ;
    }
    // cau b
    public void cong(SoPhuc a, SoPhuc b)
    {
        double phanThuc, phanAo ; 
        phanThuc = a.thuc + b.thuc ;
        phanAo = a.ao + b.ao ;
        System.out.println(phanThuc + "+" + phanAo + "i") ;
    }
    public void tru(SoPhuc a, SoPhuc b)
    {
        double phanThuc, phanAo ; 
        phanThuc = a.thuc - b.thuc ;
        phanAo = a.ao - b.ao ;
        System.out.println(phanThuc + "+" + phanAo + "i") ;
    }
    public void nhan(SoPhuc a, SoPhuc b)
    {
        double phanThuc, phanAo ; 
        phanThuc = a.thuc*b.thuc - a.ao*b.ao ;
        phanAo = a.thuc*b.ao + b.thuc*a.ao ;
        System.out.println(phanThuc + "+" + phanAo + "i") ;
    }
    public void chia(SoPhuc a, SoPhuc b)
    {
        double phanThuc, phanAo ; 
        phanThuc = (b.thuc*a.thuc + a.ao*b.ao)/(a.thuc*a.thuc + a.ao*a.ao) ;
        phanAo = (a.thuc*b.ao - b.thuc*a.ao)/(a.thuc*a.thuc + a.ao*a.ao)  ;
        System.out.println(phanThuc + "+" + phanAo + "i") ;
    }
    // cau c
    public double getPhanThuc()
    {
        return this.thuc ;
    }

    public double getPhanAo()
    {
        return this.ao ;
    }
    public void setPhanThuc(double thuc)
    {
        this.thuc = thuc ;
    }
    public void setPhanAo(double ao)
    {
        this.ao = ao ; 
    }
    // in thong tin so phuc ma nguoi dung nhap vo
    public String toString()
    {
        return this.thuc + "+" + this.ao + "i" ;
    }
    // ham Main test ket qua
    public static void main(String[] args)
    {
        SoPhuc a = new SoPhuc(1,2) ;
        SoPhuc b = new SoPhuc(3,4) ;
        System.out.println(a) ;
        System.out.println(b) ;
        a.cong(a, b);
        a.tru(a, b);
        a.nhan(a, b);
        a.chia(b, a);
    }
}
