def zip(a,b):
    iterator = 0
    ret = ()
    while(iterator<len(a)):
        ret += ((a[iterator],b[iterator]),)
        iterator += 1
    return(ret)

print(zip((True, 0, []),(False, 1, ())))
