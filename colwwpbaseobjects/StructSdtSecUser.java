package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SecUser", namespace ="ProjectThani")
public final  class StructSdtSecUser implements Cloneable, java.io.Serializable
{
   public StructSdtSecUser( )
   {
      this( -1, new ModelContext( StructSdtSecUser.class ));
   }

   public StructSdtSecUser( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtSecUser( java.util.Vector<StructSdtSecUser> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SecUser",namespace="ProjectThani")
   public java.util.Vector<StructSdtSecUser> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSecUser> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSecUser> item = new java.util.Vector<>();
}

