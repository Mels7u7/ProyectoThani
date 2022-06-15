package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethomesampledata extends GXProcedure
{
   public gethomesampledata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethomesampledata.class ), "" );
   }

   public gethomesampledata( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> executeUdp( )
   {
      gethomesampledata.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>[] aP0 )
   {
      gethomesampledata.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Beer" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(1200) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(2000) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(400) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(10) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(1) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Wine" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(890) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(100) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(3000) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(12) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(2) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Lollipop" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(200) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(3098) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(250) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(20) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(3) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Apple" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(48) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(879) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(235) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(42) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(1) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Cherries" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(232) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(6788) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(213) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(34) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(4) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Steak" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(345) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(370) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(230) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(0) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(1) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Cupcake" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(340) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(1200) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(230) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(10) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(4) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Strawberry" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(120) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(600) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(239) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(10) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(1) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Ice cream" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(70) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(1200) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(120) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(8) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(2) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Frapuccino" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(670) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(124) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(489) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(5) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(1) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Candy" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(1200) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(2000) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(400) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(10) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(1) );
      Gxm1homesampledata = (com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem)new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homesampledata, 0);
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productname( "Pizza" );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productprice( DecimalUtil.doubleToDec(3400) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productvolume( DecimalUtil.doubleToDec(120) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productweight( DecimalUtil.doubleToDec(320) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productdiscount( DecimalUtil.doubleToDec(8) );
      Gxm1homesampledata.setgxTv_SdtHomeSampleData_HomeSampleDataItem_Productstatus( (byte)(4) );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = gethomesampledata.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>(com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem.class, "HomeSampleDataItem", "ProjectThani", remoteHandle);
      Gxm1homesampledata = new com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem>[] aP0 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem> Gxm2rootcol ;
   private com.projectthani.wwpbaseobjects.SdtHomeSampleData_HomeSampleDataItem Gxm1homesampledata ;
}

