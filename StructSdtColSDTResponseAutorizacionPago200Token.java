package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseAutorizacionPago200Token", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseAutorizacionPago200Token implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseAutorizacionPago200Token( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseAutorizacionPago200Token.class ));
   }

   public StructSdtColSDTResponseAutorizacionPago200Token( int remoteHandle ,
                                                           ModelContext context )
   {
   }

   public  StructSdtColSDTResponseAutorizacionPago200Token( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Token> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseAutorizacionPago200Token",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseAutorizacionPago200Token> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseAutorizacionPago200Token> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseAutorizacionPago200Token> item = new java.util.Vector<>();
}

