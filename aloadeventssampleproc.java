package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aloadeventssampleproc extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      aloadeventssampleproc pgm = new aloadeventssampleproc (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      java.util.Date aP0 = GXutil.nullDate();
      java.util.Date aP1 = GXutil.nullDate();
      com.projectthani.SdtSchedulerEvents[] aP2 = new com.projectthani.SdtSchedulerEvents[] {new com.projectthani.SdtSchedulerEvents()};

      try
      {
         aP0 = (java.util.Date) localUtil.ctod( args[0], 3);
         aP1 = (java.util.Date) localUtil.ctod( args[1], 3);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1, aP2);
   }

   public aloadeventssampleproc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aloadeventssampleproc.class ), "" );
   }

   public aloadeventssampleproc( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.SdtSchedulerEvents executeUdp( java.util.Date aP0 ,
                                                          java.util.Date aP1 )
   {
      aloadeventssampleproc.this.aP2 = new com.projectthani.SdtSchedulerEvents[] {new com.projectthani.SdtSchedulerEvents()};
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
      aloadeventssampleproc.this.AV10dateFrom = aP0;
      aloadeventssampleproc.this.AV11dateTo = aP1;
      aloadeventssampleproc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8event.setgxTv_SdtSchedulerEvents_event_Id( "Sample1" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Name( "Wimbledon Match" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Notes( "Wimbledon Match" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Link( "http://www.genexus.com" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Starttime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(15), (byte)(30), (byte)(0)) );
      AV8event.setgxTv_SdtSchedulerEvents_event_Endtime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(17), (byte)(30), (byte)(0)) );
      AV8event.setgxTv_SdtSchedulerEvents_event_Additionalinformation( "" );
      AV9events.getgxTv_SdtSchedulerEvents_Items().add(AV8event, 0);
      AV8event = (com.projectthani.SdtSchedulerEvents_event)new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      AV8event.setgxTv_SdtSchedulerEvents_event_Id( "Sample2" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Name( "NBA Finals" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Notes( "NBA Finals" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Link( "http://www.gxtechnical.com" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Starttime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(21), (byte)(0), (byte)(0)) );
      AV8event.setgxTv_SdtSchedulerEvents_event_Endtime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)), (byte)(22), (byte)(45), (byte)(0)) );
      AV8event.setgxTv_SdtSchedulerEvents_event_Additionalinformation( "" );
      AV9events.getgxTv_SdtSchedulerEvents_Items().add(AV8event, 0);
      AV8event = (com.projectthani.SdtSchedulerEvents_event)new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      AV8event.setgxTv_SdtSchedulerEvents_event_Id( "Sample3" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Name( "Meeting with clients" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Notes( "Meeting with clients" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Link( "http://www.gxtechnical.com/gxsearch" );
      AV8event.setgxTv_SdtSchedulerEvents_event_Starttime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)+1), (byte)(8), (byte)(30), (byte)(0)) );
      AV8event.setgxTv_SdtSchedulerEvents_event_Endtime( localUtil.ymdhmsToT( (short)(GXutil.year( Gx_date)), (byte)(GXutil.month( Gx_date)), (byte)(GXutil.day( Gx_date)+1), (byte)(11), (byte)(30), (byte)(0)) );
      AV8event.setgxTv_SdtSchedulerEvents_event_Additionalinformation( "" );
      AV9events.getgxTv_SdtSchedulerEvents_Items().add(AV8event, 0);
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(loadeventssampleproc.class);
      return new com.projectthani.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP2[0] = aloadeventssampleproc.this.AV9events;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9events = new com.projectthani.SdtSchedulerEvents(remoteHandle, context);
      AV8event = new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      Gx_date = GXutil.nullDate() ;
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.util.Date AV10dateFrom ;
   private java.util.Date AV11dateTo ;
   private java.util.Date Gx_date ;
   private com.projectthani.SdtSchedulerEvents_event AV8event ;
   private com.projectthani.SdtSchedulerEvents[] aP2 ;
   private com.projectthani.SdtSchedulerEvents AV9events ;
}

