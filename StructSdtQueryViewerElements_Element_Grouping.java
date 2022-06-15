package com.projectthani ;
import com.genexus.*;

public final  class StructSdtQueryViewerElements_Element_Grouping implements Cloneable, java.io.Serializable
{
   public StructSdtQueryViewerElements_Element_Grouping( )
   {
      this( -1, new ModelContext( StructSdtQueryViewerElements_Element_Grouping.class ));
   }

   public StructSdtQueryViewerElements_Element_Grouping( int remoteHandle ,
                                                         ModelContext context )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle = "" ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle = "" ;
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

   public boolean getGroupbyyear( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear ;
   }

   public void setGroupbyyear( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear = value ;
   }

   public String getYeartitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle ;
   }

   public void setYeartitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle = value ;
   }

   public boolean getGroupbysemester( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester ;
   }

   public void setGroupbysemester( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester = value ;
   }

   public String getSemestertitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle ;
   }

   public void setSemestertitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle = value ;
   }

   public boolean getGroupbyquarter( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter ;
   }

   public void setGroupbyquarter( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter = value ;
   }

   public String getQuartertitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle ;
   }

   public void setQuartertitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle = value ;
   }

   public boolean getGroupbymonth( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth ;
   }

   public void setGroupbymonth( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth = value ;
   }

   public String getMonthtitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle ;
   }

   public void setMonthtitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle = value ;
   }

   public boolean getGroupbydayofweek( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek ;
   }

   public void setGroupbydayofweek( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek = value ;
   }

   public String getDayofweektitle( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle ;
   }

   public void setDayofweektitle( String value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle = value ;
   }

   public boolean getHidevalue( )
   {
      return gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue ;
   }

   public void setHidevalue( boolean value )
   {
      gxTv_SdtQueryViewerElements_Element_Grouping_N = (byte)(0) ;
      gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue = value ;
   }

   protected byte gxTv_SdtQueryViewerElements_Element_Grouping_N ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Yeartitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Semestertitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Quartertitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Monthtitle ;
   protected String gxTv_SdtQueryViewerElements_Element_Grouping_Dayofweektitle ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyyear ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbysemester ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbyquarter ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbymonth ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Groupbydayofweek ;
   protected boolean gxTv_SdtQueryViewerElements_Element_Grouping_Hidevalue ;
}

