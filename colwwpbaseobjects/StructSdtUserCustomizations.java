package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "UserCustomizations", namespace ="ProjectThani")
public final  class StructSdtUserCustomizations implements Cloneable, java.io.Serializable
{
   public StructSdtUserCustomizations( )
   {
      this( -1, new ModelContext( StructSdtUserCustomizations.class ));
   }

   public StructSdtUserCustomizations( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtUserCustomizations( java.util.Vector<StructSdtUserCustomizations> value )
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

   @javax.xml.bind.annotation.XmlElement(name="UserCustomizations",namespace="ProjectThani")
   public java.util.Vector<StructSdtUserCustomizations> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtUserCustomizations> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtUserCustomizations> item = new java.util.Vector<>();
}

