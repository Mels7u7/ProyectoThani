package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesional", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesional implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesional( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesional.class ));
   }

   public StructSdtColSDTProfesional( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtColSDTProfesional( java.util.Vector<StructSdtSDTProfesional> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesional",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesional> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesional> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesional> item = new java.util.Vector<>();
}

