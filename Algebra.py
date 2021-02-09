#Benjamin Maymir
#maymi001@umn.edu
def left(e):return e[0]
def op(e):return e[1]
def right(e):return e[2]
def isInside(v,e):
    if(len(e)==1):
        return e==v
    else:
        return isInside(v,left(e)) or isInside(v,right(e))
def solve(v,q):
    if(isInside(v,left(q))):
        return(solving(v,q))
    elif(isInside(v,right(q))):
        return(solving(v,(right(q),'=',left(q))))
    else:
        raise ValueError("Variable not found in equation")
def solving(v,q):
    if(v==left(q)):
        return q
    else:
        if(op(left(q))=='+'):
            return solving(v,solvingAdd(v,q))
        elif(op(left(q))=='-'):
            return solving(v,solvingSubtract(v,q))
        elif(op(left(q))=='*'):
            return solving(v,solvingMultiply(v,q))
        elif(op(left(q))=='/'):
            return solving(v,solvingDivide(v,q))
        else:
            raise ValueError('Operation '+op(left(q))+" is not defined")
def solvingAdd(v,q):
    if(isInside(v,left(left(q)))):
        return(left(left(q)),'=',(right(q),'-',right(left(q))))
    else:
        return(right(left(q)),'=',(right(q),'-',left(left(q))))
def solvingSubtract(v,q):
    if(isInside(v,left(left(q)))):
        return(left(left(q)),'=',(right(q),'+',right(left(q))))
    else:
        return(right(left(q)),'=',(left(left(q)),'-',right(q)))
def solvingMultiply(v,q):
    if(isInside(v,left(left(q)))):
        return(left(left(q)),'=',(right(q),'/',right(left(q))))
    else:
        return(right(left(q)),'=',(right(q),'/',left(left(q))))
def solvingDivide(v,q):
    if(isInside(v,left(left(q)))):
        return(left(left(q)),'=',(right(q),'*',right(left(q))))
    else:
        return(right(left(q)),'=',(left(left(q)),'/',right(q)))

solving('x',(('x','%','4'),'=','2'))