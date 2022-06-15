package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalPremios", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalPremios implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalPremios( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalPremios.class ));
   }

   public StructSdtColSDTProfesionalPremios( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalPremios( java.util.Vector<StructSdtSDTProfesionalPremios> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalPremios",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalPremios> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalPremios> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalPremios> item = new java.util.Vector<>();
}

