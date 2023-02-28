int TimViTriChuoiConTrongChuoiMe(const char *s, char *x)
{
    const char *dauTien = s;
    
    while(*dauTien != NULL)
    {
        if(strlen(dauTien) >= strlen(x))
        {
            if(strncmp(dauTien, x, strlen(x)) == 0)
                return (dauTien - s);
        }
        else    break ;
        
        dauTien++;
    }

    return -1;  // ko tim thay chuoi x trong s
}