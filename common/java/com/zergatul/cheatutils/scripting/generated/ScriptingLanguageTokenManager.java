/* Generated By:JJTree&JavaCC: Do not edit this line. ScriptingLanguageTokenManager.java */
package com.zergatul.cheatutils.scripting.generated;

/** Token Manager. */
public class ScriptingLanguageTokenManager implements ScriptingLanguageConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x4000000000000L) != 0L)
            return 39;
         if ((active0 & 0x4000000000L) != 0L)
            return 4;
         if ((active0 & 0x1fc0ff00L) != 0L)
         {
            jjmatchedKind = 29;
            return 19;
         }
         return -1;
      case 1:
         if ((active0 & 0x7c0f700L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 29;
               jjmatchedPos = 1;
            }
            return 19;
         }
         if ((active0 & 0x18000800L) != 0L)
            return 19;
         return -1;
      case 2:
         if ((active0 & 0x1c0e700L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 29;
               jjmatchedPos = 2;
            }
            return 19;
         }
         if ((active0 & 0x6001800L) != 0L)
            return 19;
         return -1;
      case 3:
         if ((active0 & 0x4c04700L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 3;
            return 19;
         }
         if ((active0 & 0x100a000L) != 0L)
            return 19;
         return -1;
      case 4:
         if ((active0 & 0x4804100L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 4;
            return 19;
         }
         if ((active0 & 0x400600L) != 0L)
            return 19;
         return -1;
      case 5:
         if ((active0 & 0x4800100L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 5;
            return 19;
         }
         if ((active0 & 0x4000L) != 0L)
            return 19;
         return -1;
      case 6:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 29;
            jjmatchedPos = 6;
            return 19;
         }
         if ((active0 & 0x4000100L) != 0L)
            return 19;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 62;
         return jjMoveStringLiteralDfa1_0(0xb0000000000000L);
      case 37:
         return jjStopAtPos(0, 51);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x1000000000000000L);
      case 40:
         return jjStopAtPos(0, 32);
      case 41:
         return jjStopAtPos(0, 33);
      case 42:
         return jjStopAtPos(0, 49);
      case 43:
         jjmatchedKind = 47;
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 44:
         return jjStopAtPos(0, 37);
      case 45:
         jjmatchedKind = 48;
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 46:
         return jjStartNfaWithStates_0(0, 38, 4);
      case 47:
         return jjStartNfaWithStates_0(0, 50, 39);
      case 58:
         return jjStopAtPos(0, 44);
      case 59:
         return jjStopAtPos(0, 36);
      case 60:
         jjmatchedKind = 57;
         return jjMoveStringLiteralDfa1_0(0x800000000000000L);
      case 61:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x40040000000000L);
      case 62:
         jjmatchedKind = 56;
         return jjMoveStringLiteralDfa1_0(0x400000000000000L);
      case 63:
         return jjStopAtPos(0, 43);
      case 91:
         return jjStopAtPos(0, 34);
      case 93:
         return jjStopAtPos(0, 35);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x400100L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x6000600L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x18000800L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x3000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 123:
         return jjStopAtPos(0, 39);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x2000000000000000L);
      case 125:
         return jjStopAtPos(0, 40);
      case 126:
         return jjStopAtPos(0, 63);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, 0L);
      return 1;
   }
   switch(curChar)
   {
      case 37:
         if ((active0 & 0x20000000000000L) != 0L)
            return jjStopAtPos(1, 53);
         break;
      case 38:
         if ((active0 & 0x1000000000000000L) != 0L)
            return jjStopAtPos(1, 60);
         break;
      case 43:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         break;
      case 45:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         break;
      case 47:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         break;
      case 61:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStopAtPos(1, 54);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStopAtPos(1, 55);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStopAtPos(1, 58);
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStopAtPos(1, 59);
         break;
      case 62:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 102:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(1, 27, 19);
         break;
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000400L);
      case 110:
         if ((active0 & 0x10000000L) != 0L)
         {
            jjmatchedKind = 28;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x6800100L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x408000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 124:
         if ((active0 & 0x2000000000000000L) != 0L)
            return jjStopAtPos(1, 61);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, 0L);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x2200L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x500L);
      case 114:
         if ((active0 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 25;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x4004000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000L);
      case 116:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 19);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 119:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(2, 12, 19);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x400400L);
      case 101:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(3, 15, 19);
         else if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(3, 24, 19);
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 108:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 19);
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L);
      case 101:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(4, 9, 19);
         return jjMoveStringLiteralDfa5_0(active0, 0x100L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000L);
      case 107:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(4, 22, 19);
         break;
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000L);
      case 116:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 19);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x100L);
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x4000000L);
      case 103:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 19);
         break;
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 104:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(6, 26, 19);
         break;
      case 110:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(6, 8, 19);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(7, 23, 19);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 57;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 39:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(52, 53);
                  else if (curChar == 47)
                     jjCheckNAddStates(0, 2);
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 9);
                  else if (curChar == 47)
                     jjAddStates(10, 12);
                  else if (curChar == 34)
                     jjCheckNAddStates(13, 15);
                  else if (curChar == 46)
                     jjCheckNAdd(4);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAddTwoStates(1, 2);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 16)
                        kind = 16;
                     jjCheckNAddTwoStates(2, 36);
                  }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAddTwoStates(1, 2);
                  break;
               case 3:
                  if (curChar == 46)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(16, 18);
                  break;
               case 6:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(7);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(7, 8);
                  break;
               case 9:
                  if (curChar == 34)
                     jjCheckNAddStates(13, 15);
                  break;
               case 10:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(13, 15);
                  break;
               case 12:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(13, 15);
                  break;
               case 13:
                  if (curChar == 34 && kind > 21)
                     kind = 21;
                  break;
               case 14:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(19, 22);
                  break;
               case 15:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(13, 15);
                  break;
               case 16:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 17:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 19:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(3, 9);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(21, 22);
                  break;
               case 22:
                  if (curChar != 46)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(23, 25);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(23, 25);
                  break;
               case 25:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(26);
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(26, 8);
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(27, 28);
                  break;
               case 29:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(30);
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(30, 8);
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(26, 28);
                  break;
               case 33:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(34);
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(34, 8);
                  break;
               case 35:
                  if (curChar != 48)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAddTwoStates(2, 36);
                  break;
               case 37:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAddTwoStates(37, 2);
                  break;
               case 38:
                  if (curChar == 47)
                     jjAddStates(10, 12);
                  break;
               case 40:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 41:
                  if ((0x2400L & l) != 0L && kind > 5)
                     kind = 5;
                  break;
               case 42:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
                  break;
               case 43:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 42;
                  break;
               case 44:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(45, 46);
                  break;
               case 45:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(45, 46);
                  break;
               case 46:
                  if (curChar == 42)
                     jjCheckNAddStates(29, 31);
                  break;
               case 47:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(48, 46);
                  break;
               case 48:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(48, 46);
                  break;
               case 49:
                  if (curChar == 47 && kind > 6)
                     kind = 6;
                  break;
               case 50:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 51:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(52, 53);
                  break;
               case 52:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(52, 53);
                  break;
               case 53:
                  if (curChar == 42)
                     jjCheckNAddStates(32, 34);
                  break;
               case 54:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(55, 53);
                  break;
               case 55:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(55, 53);
                  break;
               case 56:
                  if (curChar == 47 && kind > 7)
                     kind = 7;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 19:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAdd(19);
                  break;
               case 2:
                  if ((0x100000001000L & l) != 0L && kind > 16)
                     kind = 16;
                  break;
               case 5:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(35, 36);
                  break;
               case 8:
                  if ((0x5000000050L & l) != 0L && kind > 19)
                     kind = 19;
                  break;
               case 10:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(13, 15);
                  break;
               case 11:
                  if (curChar == 92)
                     jjAddStates(37, 39);
                  break;
               case 12:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(13, 15);
                  break;
               case 24:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(40, 41);
                  break;
               case 28:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(42, 43);
                  break;
               case 32:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(44, 45);
                  break;
               case 36:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(37);
                  break;
               case 37:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjCheckNAddTwoStates(37, 2);
                  break;
               case 40:
                  jjAddStates(0, 2);
                  break;
               case 45:
                  jjCheckNAddTwoStates(45, 46);
                  break;
               case 47:
               case 48:
                  jjCheckNAddTwoStates(48, 46);
                  break;
               case 52:
                  jjCheckNAddTwoStates(52, 53);
                  break;
               case 54:
               case 55:
                  jjCheckNAddTwoStates(55, 53);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 10:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(13, 15);
                  break;
               case 40:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(0, 2);
                  break;
               case 45:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(45, 46);
                  break;
               case 47:
               case 48:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(48, 46);
                  break;
               case 52:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(52, 53);
                  break;
               case 54:
               case 55:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(55, 53);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 57 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   40, 41, 43, 21, 22, 27, 28, 31, 32, 8, 39, 50, 51, 10, 11, 13, 
   4, 5, 8, 10, 11, 15, 13, 23, 24, 8, 31, 32, 8, 46, 47, 49, 
   53, 54, 56, 6, 7, 12, 14, 16, 25, 26, 29, 30, 33, 34, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\142\157\157\154\145\141\156", 
"\146\141\154\163\145", "\146\154\157\141\164", "\151\156\164", "\156\145\167", "\156\165\154\154", 
"\163\164\162\151\156\147", "\164\162\165\145", null, null, null, null, null, null, 
"\142\162\145\141\153", "\143\157\156\164\151\156\165\145", "\145\154\163\145", "\146\157\162", 
"\146\157\162\145\141\143\150", "\151\146", "\151\156", null, null, null, "\50", "\51", "\133", "\135", "\73", 
"\54", "\56", "\173", "\175", "\75", "\75\76", "\77", "\72", "\53\53", "\55\55", 
"\53", "\55", "\52", "\57", "\45", "\41\57", "\41\45", "\75\75", "\41\75", "\76", 
"\74", "\76\75", "\74\75", "\46\46", "\174\174", "\41", "\176", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xffffffff3fe9ff01L, 0x0L, 
};
static final long[] jjtoSkip = {
   0xfeL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0xe0L, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[57];
private final int[] jjstateSet = new int[114];
protected char curChar;
/** Constructor. */
public ScriptingLanguageTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ScriptingLanguageTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 57; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
