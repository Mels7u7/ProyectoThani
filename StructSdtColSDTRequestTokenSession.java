package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTRequestTokenSession", namespace ="ProjectThani")
public final  class StructSdtColSDTRequestTokenSession implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTRequestTokenSession( )
   {
      this( -1, new ModelContext( StructSdtColSDTRequestTokenSession.class ));
   }

   public StructSdtColSDTRequestTokenSession( int remoteHandle ,
                                              ModelContext context )
   {
   }

   public  StructSdtColSDTRequestTokenSession( java.util.Vector<StructSdtSDTRequestTokenSession> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTRequestTokenSession",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTRequestTokenSession> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTRequestTokenSession> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTRequestTokenSession> item = new java.util.Vector<>();
}

