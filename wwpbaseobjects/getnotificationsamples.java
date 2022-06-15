package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnotificationsamples extends GXProcedure
{
   public getnotificationsamples( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnotificationsamples.class ), "" );
   }

   public getnotificationsamples( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> executeUdp( )
   {
      getnotificationsamples.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>[] aP0 )
   {
      getnotificationsamples.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1wwp_sdtnotificationsdatasample = (com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdatasample, 0);
      AV5DateTime = GXutil.now( ) ;
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( "fas fa-layer-group NotificationFontIconSuccess" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( "Group Records & Totalizers" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( "Group the records of a grid within a certain column and show totalizers of each group" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( AV5DateTime );
      Gxm1wwp_sdtnotificationsdatasample = (com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdatasample, 0);
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( "fas fa-palette NotificationFontIconWarning" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( "Dark Designs" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( "Option to select dark designs in the Design System Wizard" );
      AV5DateTime = GXutil.dtadd( AV5DateTime, 3600*(-2)) ;
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( AV5DateTime );
      Gxm1wwp_sdtnotificationsdatasample = (com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdatasample, 0);
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( "fas fa-cog NotificationFontIconDanger" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( "100% Customizable" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( "Customize and create your own design system" );
      AV5DateTime = GXutil.dtadd( AV5DateTime, 3600*(-5)) ;
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( AV5DateTime );
      Gxm1wwp_sdtnotificationsdatasample = (com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdatasample, 0);
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( "far fa-star NotificationFontIconInfo" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( "Bookmarks" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( "Bookmark pages and have their shortcuts in the Master Page" );
      AV5DateTime = GXutil.dtadd( AV5DateTime, 3600*(-8)) ;
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( AV5DateTime );
      Gxm1wwp_sdtnotificationsdatasample = (com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdatasample, 0);
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( "fas fa-plus NotificationFontIconSuccess" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( "Add new" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( "Add new record of a DVelop Combo while editing other record" );
      AV5DateTime = GXutil.dtadd( AV5DateTime, 3600*(-36)) ;
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( AV5DateTime );
      Gxm1wwp_sdtnotificationsdatasample = (com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem)new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_sdtnotificationsdatasample, 0);
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationiconclass( "fas fa-caret-down NotificationFontIconInfoLight" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationtitle( "Expand record" );
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdescription( "Expand record of a grid in order to visualize more information" );
      AV5DateTime = GXutil.dtadd( AV5DateTime, 3600*(-65)) ;
      Gxm1wwp_sdtnotificationsdatasample.setgxTv_SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem_Notificationdatetime( AV5DateTime );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getnotificationsamples.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>(com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem.class, "WWP_SDTNotificationsDataSampleItem", "ProjectThani", remoteHandle);
      Gxm1wwp_sdtnotificationsdatasample = new com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem(remoteHandle, context);
      AV5DateTime = GXutil.resetTime( GXutil.nullDate() );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.util.Date AV5DateTime ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem>[] aP0 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem> Gxm2rootcol ;
   private com.projectthani.wwpbaseobjects.SdtWWP_SDTNotificationsDataSample_WWP_SDTNotificationsDataSampleItem Gxm1wwp_sdtnotificationsdatasample ;
}

