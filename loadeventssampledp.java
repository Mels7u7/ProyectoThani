package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadeventssampledp extends GXProcedure
{
   public loadeventssampledp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadeventssampledp.class ), "" );
   }

   public loadeventssampledp( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.SdtSchedulerEvents executeUdp( java.util.Date aP0 ,
                                                          java.util.Date aP1 )
   {
      loadeventssampledp.this.aP2 = new com.projectthani.SdtSchedulerEvents[] {new com.projectthani.SdtSchedulerEvents()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( java.util.Date aP0 ,
                        java.util.Date aP1 ,
                        com.projectthani.SdtSchedulerEvents[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( java.util.Date aP0 ,
                             java.util.Date aP1 ,
                             com.projectthani.SdtSchedulerEvents[] aP2 )
   {
      loadeventssampledp.this.AV5dateFrom = aP0;
      loadeventssampledp.this.AV6dateTo = aP1;
      loadeventssampledp.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxm1schedulerevents_items = (com.projectthani.SdtSchedulerEvents_event)new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      Gxm2schedulerevents.getgxTv_SdtSchedulerEvents_Items().add(Gxm1schedulerevents_items, 0);
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Id( "Sample1" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Name( "Disponibilidad 1" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Notes( "Disponibilidad Prueba Profesional Especialidad" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Link( "http://www.genexus.com" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Starttime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(15), (byte)(30), (byte)(0)) );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Endtime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(17), (byte)(30), (byte)(0)) );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Additionalinformation( "" );
      Gxm1schedulerevents_items = (com.projectthani.SdtSchedulerEvents_event)new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      Gxm2schedulerevents.getgxTv_SdtSchedulerEvents_Items().add(Gxm1schedulerevents_items, 0);
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Id( "Sample2" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Name( "Disponibilidad 2" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Notes( "Disponibilidad Prueba Fernando - Dermatología" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Link( "http://www.gxtechnical.com" );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Starttime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(21), (byte)(0), (byte)(0)) );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Endtime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(22), (byte)(45), (byte)(0)) );
      Gxm1schedulerevents_items.setgxTv_SdtSchedulerEvents_event_Additionalinformation( "" );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = loadeventssampledp.this.Gxm2schedulerevents;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2schedulerevents = new com.projectthani.SdtSchedulerEvents(remoteHandle, context);
      Gxm1schedulerevents_items = new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      Gx_date = GXutil.nullDate() ;
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.util.Date AV5dateFrom ;
   private java.util.Date AV6dateTo ;
   private java.util.Date Gx_date ;
   private com.projectthani.SdtSchedulerEvents[] aP2 ;
   private com.projectthani.SdtSchedulerEvents Gxm2schedulerevents ;
   private com.projectthani.SdtSchedulerEvents_event Gxm1schedulerevents_items ;
}

