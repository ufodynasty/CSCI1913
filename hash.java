//Benjamin Maymir
//maymi001@umn.edu
class Reserved
{
  private static final String [] reserved =
  { "and",
    "begin",
    "define",
    "do",
    "else",
    "end",
    "if",
    "not",
    "or",
    "return",
    "then",
    "while" 
  };

  private static int hash(String name)
  {
    //return(1);
    return(name.charAt(0)+7*name.length());
  }

  public static void main(String [] args)
  {
    for (int index = 0; index < reserved.length ; index += 1)
    {
      System.out.print("h(\"" + reserved[index] + "\") = ");
      System.out.print(hash(reserved[index]));
      System.out.println();
    }
  }
}
//output
// h("and") = 118
// h("begin") = 133
// h("define") = 142
// h("do") = 114
// h("else") = 129
// h("end") = 122
// h("if") = 119
// h("not") = 131
// h("or") = 125
// h("return") = 156
// h("then") = 144
// h("while") = 154