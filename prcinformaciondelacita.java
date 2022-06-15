package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinformaciondelacita extends GXProcedure
{
   public prcinformaciondelacita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinformaciondelacita.class ), "" );
   }

   public prcinformaciondelacita( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> executeUdp( int aP0 )
   {
      prcinformaciondelacita.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>[] aP1 )
   {
      prcinformaciondelacita.this.AV10DisponibilidadId = aP0;
      prcinformaciondelacita.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10DisponibilidadId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A77SGSedeDisponibilidadClinicaId = P006I2_A77SGSedeDisponibilidadClinicaId[0] ;
         A34DisponibilidadId = P006I2_A34DisponibilidadId[0] ;
         A40000ProfesionalFoto_GXI = P006I2_A40000ProfesionalFoto_GXI[0] ;
         A86ProfesionalApellidoMaterno = P006I2_A86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P006I2_A85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P006I2_A84ProfesionalNombres[0] ;
         A189ProfesionalFoto = P006I2_A189ProfesionalFoto[0] ;
         A71EspecialidadNombre = P006I2_A71EspecialidadNombre[0] ;
         A67DisponibilidadFecha = P006I2_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P006I2_n67DisponibilidadFecha[0] ;
         A135DisponibilidadHoraFin = P006I2_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = P006I2_n135DisponibilidadHoraFin[0] ;
         A69DisponibilidadHoraInicio = P006I2_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = P006I2_n69DisponibilidadHoraInicio[0] ;
         A298DisponibilidadTipoCita = P006I2_A298DisponibilidadTipoCita[0] ;
         A31ProfesionalId = P006I2_A31ProfesionalId[0] ;
         A32EspecialidadId = P006I2_A32EspecialidadId[0] ;
         A35SGSedeDisponibilidadSedeId = P006I2_A35SGSedeDisponibilidadSedeId[0] ;
         A79SGSedeDisponibilidadClinicaAbreviado = P006I2_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         A74SGSedeDisponibilidadSedeNombre = P006I2_A74SGSedeDisponibilidadSedeNombre[0] ;
         A40000ProfesionalFoto_GXI = P006I2_A40000ProfesionalFoto_GXI[0] ;
         A86ProfesionalApellidoMaterno = P006I2_A86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P006I2_A85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P006I2_A84ProfesionalNombres[0] ;
         A189ProfesionalFoto = P006I2_A189ProfesionalFoto[0] ;
         A71EspecialidadNombre = P006I2_A71EspecialidadNombre[0] ;
         A77SGSedeDisponibilidadClinicaId = P006I2_A77SGSedeDisponibilidadClinicaId[0] ;
         A74SGSedeDisponibilidadSedeNombre = P006I2_A74SGSedeDisponibilidadSedeNombre[0] ;
         A79SGSedeDisponibilidadClinicaAbreviado = P006I2_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid( (short)(A34DisponibilidadId) );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor( A84ProfesionalNombres+" "+A85ProfesionalApellidoPaterno+" "+A86ProfesionalApellidoMaterno );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor( A189ProfesionalFoto );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor_gxi( A40000ProfesionalFoto_GXI );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor( A71EspecialidadNombre );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha( A67DisponibilidadFecha );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora( localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")+"-"+localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ") );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( A298DisponibilidadTipoCita );
         GXv_decimal1[0] = AV8CostoCita ;
         GXv_boolean2[0] = AV13isExist ;
         new com.projectthani.prcgetcostoconsulta(remoteHandle, context).execute( A31ProfesionalId, A32EspecialidadId, A35SGSedeDisponibilidadSedeId, A298DisponibilidadTipoCita, GXv_decimal1, GXv_boolean2) ;
         prcinformaciondelacita.this.AV8CostoCita = GXv_decimal1[0] ;
         prcinformaciondelacita.this.AV13isExist = GXv_boolean2[0] ;
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto( (short)(DecimalUtil.decToDouble(AV8CostoCita)) );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica( A79SGSedeDisponibilidadClinicaAbreviado );
         AV11InfCita.setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede( A74SGSedeDisponibilidadSedeNombre );
         AV12InfCitaArray.add(AV11InfCita, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcinformaciondelacita.this.AV12InfCitaArray;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12InfCitaArray = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P006I2_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      P006I2_A34DisponibilidadId = new int[1] ;
      P006I2_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P006I2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P006I2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P006I2_A84ProfesionalNombres = new String[] {""} ;
      P006I2_A189ProfesionalFoto = new String[] {""} ;
      P006I2_A71EspecialidadNombre = new String[] {""} ;
      P006I2_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006I2_n67DisponibilidadFecha = new boolean[] {false} ;
      P006I2_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P006I2_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P006I2_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P006I2_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      P006I2_A298DisponibilidadTipoCita = new String[] {""} ;
      P006I2_A31ProfesionalId = new int[1] ;
      P006I2_A32EspecialidadId = new short[1] ;
      P006I2_A35SGSedeDisponibilidadSedeId = new short[1] ;
      P006I2_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      P006I2_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      A40000ProfesionalFoto_GXI = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A84ProfesionalNombres = "" ;
      A189ProfesionalFoto = "" ;
      A71EspecialidadNombre = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A298DisponibilidadTipoCita = "" ;
      A79SGSedeDisponibilidadClinicaAbreviado = "" ;
      A74SGSedeDisponibilidadSedeNombre = "" ;
      AV11InfCita = new com.projectthani.SdtSDTInformacionDeLaCita(remoteHandle, context);
      AV8CostoCita = DecimalUtil.stringToDec("0.00") ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_boolean2 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinformaciondelacita__default(),
         new Object[] {
             new Object[] {
            P006I2_A77SGSedeDisponibilidadClinicaId, P006I2_A34DisponibilidadId, P006I2_A40000ProfesionalFoto_GXI, P006I2_A86ProfesionalApellidoMaterno, P006I2_A85ProfesionalApellidoPaterno, P006I2_A84ProfesionalNombres, P006I2_A189ProfesionalFoto, P006I2_A71EspecialidadNombre, P006I2_A67DisponibilidadFecha, P006I2_n67DisponibilidadFecha,
            P006I2_A135DisponibilidadHoraFin, P006I2_n135DisponibilidadHoraFin, P006I2_A69DisponibilidadHoraInicio, P006I2_n69DisponibilidadHoraInicio, P006I2_A298DisponibilidadTipoCita, P006I2_A31ProfesionalId, P006I2_A32EspecialidadId, P006I2_A35SGSedeDisponibilidadSedeId, P006I2_A79SGSedeDisponibilidadClinicaAbreviado, P006I2_A74SGSedeDisponibilidadSedeNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A77SGSedeDisponibilidadClinicaId ;
   private short A32EspecialidadId ;
   private short A35SGSedeDisponibilidadSedeId ;
   private short Gx_err ;
   private int AV10DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private java.math.BigDecimal AV8CostoCita ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String scmdbuf ;
   private String A298DisponibilidadTipoCita ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean n67DisponibilidadFecha ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean AV13isExist ;
   private boolean GXv_boolean2[] ;
   private String A40000ProfesionalFoto_GXI ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A84ProfesionalNombres ;
   private String A71EspecialidadNombre ;
   private String A79SGSedeDisponibilidadClinicaAbreviado ;
   private String A74SGSedeDisponibilidadSedeNombre ;
   private String A189ProfesionalFoto ;
   private com.projectthani.SdtSDTInformacionDeLaCita AV11InfCita ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P006I2_A77SGSedeDisponibilidadClinicaId ;
   private int[] P006I2_A34DisponibilidadId ;
   private String[] P006I2_A40000ProfesionalFoto_GXI ;
   private String[] P006I2_A86ProfesionalApellidoMaterno ;
   private String[] P006I2_A85ProfesionalApellidoPaterno ;
   private String[] P006I2_A84ProfesionalNombres ;
   private String[] P006I2_A189ProfesionalFoto ;
   private String[] P006I2_A71EspecialidadNombre ;
   private java.util.Date[] P006I2_A67DisponibilidadFecha ;
   private boolean[] P006I2_n67DisponibilidadFecha ;
   private java.util.Date[] P006I2_A135DisponibilidadHoraFin ;
   private boolean[] P006I2_n135DisponibilidadHoraFin ;
   private java.util.Date[] P006I2_A69DisponibilidadHoraInicio ;
   private boolean[] P006I2_n69DisponibilidadHoraInicio ;
   private String[] P006I2_A298DisponibilidadTipoCita ;
   private int[] P006I2_A31ProfesionalId ;
   private short[] P006I2_A32EspecialidadId ;
   private short[] P006I2_A35SGSedeDisponibilidadSedeId ;
   private String[] P006I2_A79SGSedeDisponibilidadClinicaAbreviado ;
   private String[] P006I2_A74SGSedeDisponibilidadSedeNombre ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV12InfCitaArray ;
}

final  class prcinformaciondelacita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006I2", "SELECT T4.[ClinicaId] AS SGSedeDisponibilidadClinicaId, T1.[DisponibilidadId], T2.[ProfesionalFoto_GXI], T2.[ProfesionalApellidoMaterno], T2.[ProfesionalApellidoPaterno], T2.[ProfesionalNombres], T2.[ProfesionalFoto], T3.[EspecialidadNombre], T1.[DisponibilidadFecha], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadTipoCita], T1.[ProfesionalId], T1.[EspecialidadId], T1.[SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId, T5.[ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado, T4.[SedeNombre] AS SGSedeDisponibilidadSedeNombre FROM (((([Disponibilidad] T1 INNER JOIN [Profesional] T2 ON T2.[ProfesionalId] = T1.[ProfesionalId]) INNER JOIN [Especialidad] T3 ON T3.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Sede] T4 ON T4.[SedeId] = T1.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T5 ON T5.[ClinicaId] = T4.[ClinicaId]) WHERE T1.[DisponibilidadId] = ? ORDER BY T1.[DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getMultimediaFile(7, rslt.getVarchar(3));
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(11));
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(12, 1);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((short[]) buf[16])[0] = rslt.getShort(14);
               ((short[]) buf[17])[0] = rslt.getShort(15);
               ((String[]) buf[18])[0] = rslt.getVarchar(16);
               ((String[]) buf[19])[0] = rslt.getVarchar(17);
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

