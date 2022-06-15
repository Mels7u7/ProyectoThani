package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aproccargardisponibilidadcalendario extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      aproccargardisponibilidadcalendario pgm = new aproccargardisponibilidadcalendario (-1);
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

   public aproccargardisponibilidadcalendario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aproccargardisponibilidadcalendario.class ), "" );
   }

   public aproccargardisponibilidadcalendario( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.SdtSchedulerEvents executeUdp( java.util.Date aP0 ,
                                                          java.util.Date aP1 )
   {
      aproccargardisponibilidadcalendario.this.aP2 = new com.projectthani.SdtSchedulerEvents[] {new com.projectthani.SdtSchedulerEvents()};
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
      aproccargardisponibilidadcalendario.this.AV9dateFrom = aP0;
      aproccargardisponibilidadcalendario.this.AV10dateTo = aP1;
      aproccargardisponibilidadcalendario.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13ProfesionalChar = AV8websession.getValue("FiltroProfesional") ;
      AV14ProfesionalId = (int)(GXutil.lval( AV13ProfesionalChar)) ;
      AV12events = (com.projectthani.SdtSchedulerEvents)new com.projectthani.SdtSchedulerEvents(remoteHandle, context);
      httpContext.GX_msglist.addItem(GXutil.str( AV14ProfesionalId, 8, 0));
      if ( AV14ProfesionalId > 0 )
      {
         /* Using cursor P00613 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV14ProfesionalId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A34DisponibilidadId = P00613_A34DisponibilidadId[0] ;
            A31ProfesionalId = P00613_A31ProfesionalId[0] ;
            A136DisponibilidadEstado = P00613_A136DisponibilidadEstado[0] ;
            A133EventId = P00613_A133EventId[0] ;
            A134DisponibilidadDescription = P00613_A134DisponibilidadDescription[0] ;
            A69DisponibilidadHoraInicio = P00613_A69DisponibilidadHoraInicio[0] ;
            n69DisponibilidadHoraInicio = P00613_n69DisponibilidadHoraInicio[0] ;
            A67DisponibilidadFecha = P00613_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = P00613_n67DisponibilidadFecha[0] ;
            A135DisponibilidadHoraFin = P00613_A135DisponibilidadHoraFin[0] ;
            n135DisponibilidadHoraFin = P00613_n135DisponibilidadHoraFin[0] ;
            A181ProfesionalColorCita = P00613_A181ProfesionalColorCita[0] ;
            A180ProfesionalColorDisponible = P00613_A180ProfesionalColorDisponible[0] ;
            A138DCitaId = P00613_A138DCitaId[0] ;
            n138DCitaId = P00613_n138DCitaId[0] ;
            A86ProfesionalApellidoMaterno = P00613_A86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = P00613_A85ProfesionalApellidoPaterno[0] ;
            A84ProfesionalNombres = P00613_A84ProfesionalNombres[0] ;
            A138DCitaId = P00613_A138DCitaId[0] ;
            n138DCitaId = P00613_n138DCitaId[0] ;
            A181ProfesionalColorCita = P00613_A181ProfesionalColorCita[0] ;
            A180ProfesionalColorDisponible = P00613_A180ProfesionalColorDisponible[0] ;
            A86ProfesionalApellidoMaterno = P00613_A86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = P00613_A85ProfesionalApellidoPaterno[0] ;
            A84ProfesionalNombres = P00613_A84ProfesionalNombres[0] ;
            A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
            AV11event = (com.projectthani.SdtSchedulerEvents_event)new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
            AV11event.setgxTv_SdtSchedulerEvents_event_Id( A133EventId );
            AV11event.setgxTv_SdtSchedulerEvents_event_Name( A83ProfesionalNombreCompleto );
            AV11event.setgxTv_SdtSchedulerEvents_event_Notes( A134DisponibilidadDescription );
            AV11event.setgxTv_SdtSchedulerEvents_event_Starttime( localUtil.ymdhmsToT( (short)(GXutil.year( A67DisponibilidadFecha)), (byte)(GXutil.month( A67DisponibilidadFecha)), (byte)(GXutil.day( A67DisponibilidadFecha)), (byte)(GXutil.hour( A69DisponibilidadHoraInicio)), (byte)(GXutil.minute( A69DisponibilidadHoraInicio)), (byte)(GXutil.second( A69DisponibilidadHoraInicio))) );
            AV11event.setgxTv_SdtSchedulerEvents_event_Endtime( localUtil.ymdhmsToT( (short)(GXutil.year( A67DisponibilidadFecha)), (byte)(GXutil.month( A67DisponibilidadFecha)), (byte)(GXutil.day( A67DisponibilidadFecha)), (byte)(GXutil.hour( A135DisponibilidadHoraFin)), (byte)(GXutil.minute( A135DisponibilidadHoraFin)), (byte)(GXutil.second( A135DisponibilidadHoraFin))) );
            AV11event.setgxTv_SdtSchedulerEvents_event_Additionalinformation( "" );
            if ( A138DCitaId > 0 )
            {
               AV11event.setgxTv_SdtSchedulerEvents_event_Backgroundcolor( A181ProfesionalColorCita );
            }
            else
            {
               AV11event.setgxTv_SdtSchedulerEvents_event_Backgroundcolor( A180ProfesionalColorDisponible );
            }
            AV12events.getgxTv_SdtSchedulerEvents_Items().add(AV11event, 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(proccargardisponibilidadcalendario.class);
      return new com.projectthani.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP2[0] = aproccargardisponibilidadcalendario.this.AV12events;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12events = new com.projectthani.SdtSchedulerEvents(remoteHandle, context);
      AV13ProfesionalChar = "" ;
      AV8websession = httpContext.getWebSession();
      scmdbuf = "" ;
      P00613_A34DisponibilidadId = new int[1] ;
      P00613_A31ProfesionalId = new int[1] ;
      P00613_A136DisponibilidadEstado = new String[] {""} ;
      P00613_A133EventId = new String[] {""} ;
      P00613_A134DisponibilidadDescription = new String[] {""} ;
      P00613_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P00613_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P00613_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00613_n67DisponibilidadFecha = new boolean[] {false} ;
      P00613_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P00613_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P00613_A181ProfesionalColorCita = new String[] {""} ;
      P00613_A180ProfesionalColorDisponible = new String[] {""} ;
      P00613_A138DCitaId = new int[1] ;
      P00613_n138DCitaId = new boolean[] {false} ;
      P00613_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P00613_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P00613_A84ProfesionalNombres = new String[] {""} ;
      A136DisponibilidadEstado = "" ;
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A181ProfesionalColorCita = "" ;
      A180ProfesionalColorDisponible = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A84ProfesionalNombres = "" ;
      A83ProfesionalNombreCompleto = "" ;
      AV11event = new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.aproccargardisponibilidadcalendario__default(),
         new Object[] {
             new Object[] {
            P00613_A34DisponibilidadId, P00613_A31ProfesionalId, P00613_A136DisponibilidadEstado, P00613_A133EventId, P00613_A134DisponibilidadDescription, P00613_A69DisponibilidadHoraInicio, P00613_n69DisponibilidadHoraInicio, P00613_A67DisponibilidadFecha, P00613_n67DisponibilidadFecha, P00613_A135DisponibilidadHoraFin,
            P00613_n135DisponibilidadHoraFin, P00613_A181ProfesionalColorCita, P00613_A180ProfesionalColorDisponible, P00613_A138DCitaId, P00613_n138DCitaId, P00613_A86ProfesionalApellidoMaterno, P00613_A85ProfesionalApellidoPaterno, P00613_A84ProfesionalNombres
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14ProfesionalId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int A138DCitaId ;
   private String scmdbuf ;
   private String A136DisponibilidadEstado ;
   private String A133EventId ;
   private String A181ProfesionalColorCita ;
   private String A180ProfesionalColorDisponible ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date AV9dateFrom ;
   private java.util.Date AV10dateTo ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n67DisponibilidadFecha ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n138DCitaId ;
   private String AV13ProfesionalChar ;
   private String A134DisponibilidadDescription ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private com.genexus.webpanels.WebSession AV8websession ;
   private com.projectthani.SdtSchedulerEvents[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P00613_A34DisponibilidadId ;
   private int[] P00613_A31ProfesionalId ;
   private String[] P00613_A136DisponibilidadEstado ;
   private String[] P00613_A133EventId ;
   private String[] P00613_A134DisponibilidadDescription ;
   private java.util.Date[] P00613_A69DisponibilidadHoraInicio ;
   private boolean[] P00613_n69DisponibilidadHoraInicio ;
   private java.util.Date[] P00613_A67DisponibilidadFecha ;
   private boolean[] P00613_n67DisponibilidadFecha ;
   private java.util.Date[] P00613_A135DisponibilidadHoraFin ;
   private boolean[] P00613_n135DisponibilidadHoraFin ;
   private String[] P00613_A181ProfesionalColorCita ;
   private String[] P00613_A180ProfesionalColorDisponible ;
   private int[] P00613_A138DCitaId ;
   private boolean[] P00613_n138DCitaId ;
   private String[] P00613_A86ProfesionalApellidoMaterno ;
   private String[] P00613_A85ProfesionalApellidoPaterno ;
   private String[] P00613_A84ProfesionalNombres ;
   private com.projectthani.SdtSchedulerEvents AV12events ;
   private com.projectthani.SdtSchedulerEvents_event AV11event ;
}

final  class aproccargardisponibilidadcalendario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00613", "SELECT T1.[DisponibilidadId], T1.[ProfesionalId], T1.[DisponibilidadEstado], T1.[EventId], T1.[DisponibilidadDescription], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T1.[DisponibilidadHoraFin], T3.[ProfesionalColorCita], T3.[ProfesionalColorDisponible], COALESCE( T2.[DCitaId], 0) AS DCitaId, T3.[ProfesionalApellidoMaterno], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalNombres] FROM (([Disponibilidad] T1 LEFT JOIN (SELECT MIN(T4.[CitaId]) AS DCitaId, T4.[SGCitaDisponibilidadId] FROM [Cita] T4,  [Disponibilidad] T5 WHERE (T4.[SGCitaDisponibilidadId] = T5.[DisponibilidadId]) AND (T4.[CitaEstado] = 'A') GROUP BY T4.[SGCitaDisponibilidadId] ) T2 ON T2.[SGCitaDisponibilidadId] = T1.[DisponibilidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) WHERE (T1.[ProfesionalId] = ?) AND (T1.[DisponibilidadEstado] = 'A') ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(8));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((String[]) buf[12])[0] = rslt.getString(10, 20);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

