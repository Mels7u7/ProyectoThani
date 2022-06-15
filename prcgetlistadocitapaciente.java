package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetlistadocitapaciente extends GXProcedure
{
   public prcgetlistadocitapaciente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetlistadocitapaciente.class ), "" );
   }

   public prcgetlistadocitapaciente( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente> executeUdp( int aP0 )
   {
      prcgetlistadocitapaciente.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>[] aP1 )
   {
      prcgetlistadocitapaciente.this.AV17PacienteId = aP0;
      prcgetlistadocitapaciente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P006X2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17PacienteId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A20PacienteId = P006X2_A20PacienteId[0] ;
         A19CitaId = P006X2_A19CitaId[0] ;
         A64CitaCode = P006X2_A64CitaCode[0] ;
         A387SGCitaDisponibilidadHoraFin = P006X2_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P006X2_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P006X2_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P006X2_n68SGCitaDisponibilidadHoraInicio[0] ;
         A104PacienteApellidoMaterno = P006X2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006X2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P006X2_A105PacienteNombres[0] ;
         A81SGCitaDisponibilidadProfesionalId = P006X2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A86ProfesionalApellidoMaterno = P006X2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P006X2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P006X2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P006X2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P006X2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P006X2_n84ProfesionalNombres[0] ;
         A21SGCitaDisponibilidadId = P006X2_A21SGCitaDisponibilidadId[0] ;
         A89CitaEstadoCita = P006X2_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = P006X2_n89CitaEstadoCita[0] ;
         A66SGCitaDisponibilidadFecha = P006X2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P006X2_n66SGCitaDisponibilidadFecha[0] ;
         A104PacienteApellidoMaterno = P006X2_A104PacienteApellidoMaterno[0] ;
         A103PacienteApellidoPaterno = P006X2_A103PacienteApellidoPaterno[0] ;
         A105PacienteNombres = P006X2_A105PacienteNombres[0] ;
         A387SGCitaDisponibilidadHoraFin = P006X2_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = P006X2_n387SGCitaDisponibilidadHoraFin[0] ;
         A68SGCitaDisponibilidadHoraInicio = P006X2_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = P006X2_n68SGCitaDisponibilidadHoraInicio[0] ;
         A81SGCitaDisponibilidadProfesionalId = P006X2_A81SGCitaDisponibilidadProfesionalId[0] ;
         A66SGCitaDisponibilidadFecha = P006X2_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = P006X2_n66SGCitaDisponibilidadFecha[0] ;
         A86ProfesionalApellidoMaterno = P006X2_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = P006X2_n86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P006X2_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = P006X2_n85ProfesionalApellidoPaterno[0] ;
         A84ProfesionalNombres = P006X2_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = P006X2_n84ProfesionalNombres[0] ;
         AV9Citas = (com.projectthani.SdtSDTListadoCitasPorPaciente)new com.projectthani.SdtSDTListadoCitasPorPaciente(remoteHandle, context);
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Citaid( A19CitaId );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Codcita( A64CitaCode );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Fechacita( A66SGCitaDisponibilidadFecha );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Horacita( localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")+" - "+localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ") );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos( A105PacienteNombres+" "+A103PacienteApellidoPaterno+" "+A104PacienteApellidoMaterno );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid( A81SGCitaDisponibilidadProfesionalId );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos( A84ProfesionalNombres+" "+A85ProfesionalApellidoPaterno+" "+A86ProfesionalApellidoMaterno );
         GXv_char1[0] = AV11Especialidad ;
         new com.projectthani.prcgetespecialidadbydisponibilidad(remoteHandle, context).execute( A21SGCitaDisponibilidadId, GXv_char1) ;
         prcgetlistadocitapaciente.this.AV11Especialidad = GXv_char1[0] ;
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Especialidad( AV11Especialidad );
         AV9Citas.setgxTv_SdtSDTListadoCitasPorPaciente_Estadocita( A89CitaEstadoCita );
         AV14ListadoCitas.add(AV9Citas, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetlistadocitapaciente.this.AV14ListadoCitas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14ListadoCitas = new GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>(com.projectthani.SdtSDTListadoCitasPorPaciente.class, "SDTListadoCitasPorPaciente", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P006X2_A20PacienteId = new int[1] ;
      P006X2_A19CitaId = new int[1] ;
      P006X2_A64CitaCode = new String[] {""} ;
      P006X2_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P006X2_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      P006X2_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P006X2_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      P006X2_A104PacienteApellidoMaterno = new String[] {""} ;
      P006X2_A103PacienteApellidoPaterno = new String[] {""} ;
      P006X2_A105PacienteNombres = new String[] {""} ;
      P006X2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      P006X2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P006X2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      P006X2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P006X2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      P006X2_A84ProfesionalNombres = new String[] {""} ;
      P006X2_n84ProfesionalNombres = new boolean[] {false} ;
      P006X2_A21SGCitaDisponibilidadId = new int[1] ;
      P006X2_A89CitaEstadoCita = new String[] {""} ;
      P006X2_n89CitaEstadoCita = new boolean[] {false} ;
      P006X2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006X2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      A64CitaCode = "" ;
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A104PacienteApellidoMaterno = "" ;
      A103PacienteApellidoPaterno = "" ;
      A105PacienteNombres = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A84ProfesionalNombres = "" ;
      A89CitaEstadoCita = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV9Citas = new com.projectthani.SdtSDTListadoCitasPorPaciente(remoteHandle, context);
      AV11Especialidad = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetlistadocitapaciente__default(),
         new Object[] {
             new Object[] {
            P006X2_A20PacienteId, P006X2_A19CitaId, P006X2_A64CitaCode, P006X2_A387SGCitaDisponibilidadHoraFin, P006X2_n387SGCitaDisponibilidadHoraFin, P006X2_A68SGCitaDisponibilidadHoraInicio, P006X2_n68SGCitaDisponibilidadHoraInicio, P006X2_A104PacienteApellidoMaterno, P006X2_A103PacienteApellidoPaterno, P006X2_A105PacienteNombres,
            P006X2_A81SGCitaDisponibilidadProfesionalId, P006X2_A86ProfesionalApellidoMaterno, P006X2_n86ProfesionalApellidoMaterno, P006X2_A85ProfesionalApellidoPaterno, P006X2_n85ProfesionalApellidoPaterno, P006X2_A84ProfesionalNombres, P006X2_n84ProfesionalNombres, P006X2_A21SGCitaDisponibilidadId, P006X2_A89CitaEstadoCita, P006X2_n89CitaEstadoCita,
            P006X2_A66SGCitaDisponibilidadFecha, P006X2_n66SGCitaDisponibilidadFecha
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17PacienteId ;
   private int A20PacienteId ;
   private int A19CitaId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A21SGCitaDisponibilidadId ;
   private String scmdbuf ;
   private String A89CitaEstadoCita ;
   private String GXv_char1[] ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n84ProfesionalNombres ;
   private boolean n89CitaEstadoCita ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private String A64CitaCode ;
   private String A104PacienteApellidoMaterno ;
   private String A103PacienteApellidoPaterno ;
   private String A105PacienteNombres ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A84ProfesionalNombres ;
   private String AV11Especialidad ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P006X2_A20PacienteId ;
   private int[] P006X2_A19CitaId ;
   private String[] P006X2_A64CitaCode ;
   private java.util.Date[] P006X2_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] P006X2_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] P006X2_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] P006X2_n68SGCitaDisponibilidadHoraInicio ;
   private String[] P006X2_A104PacienteApellidoMaterno ;
   private String[] P006X2_A103PacienteApellidoPaterno ;
   private String[] P006X2_A105PacienteNombres ;
   private int[] P006X2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] P006X2_A86ProfesionalApellidoMaterno ;
   private boolean[] P006X2_n86ProfesionalApellidoMaterno ;
   private String[] P006X2_A85ProfesionalApellidoPaterno ;
   private boolean[] P006X2_n85ProfesionalApellidoPaterno ;
   private String[] P006X2_A84ProfesionalNombres ;
   private boolean[] P006X2_n84ProfesionalNombres ;
   private int[] P006X2_A21SGCitaDisponibilidadId ;
   private String[] P006X2_A89CitaEstadoCita ;
   private boolean[] P006X2_n89CitaEstadoCita ;
   private java.util.Date[] P006X2_A66SGCitaDisponibilidadFecha ;
   private boolean[] P006X2_n66SGCitaDisponibilidadFecha ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente> AV14ListadoCitas ;
   private com.projectthani.SdtSDTListadoCitasPorPaciente AV9Citas ;
}

final  class prcgetlistadocitapaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006X2", "SELECT T1.[PacienteId], T1.[CitaId], T1.[CitaCode], T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNombres], T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T4.[ProfesionalApellidoMaterno], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalNombres], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[CitaEstadoCita], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM ((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) WHERE T1.[PacienteId] = ? ORDER BY T3.[DisponibilidadFecha] DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(15);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
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

