package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgethorariodisponibledoctor extends GXProcedure
{
   public prcgethorariodisponibledoctor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgethorariodisponibledoctor.class ), "" );
   }

   public prcgethorariodisponibledoctor( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor> executeUdp( short aP0 ,
                                                                              java.util.Date aP1 ,
                                                                              java.util.Date aP2 ,
                                                                              String aP3 )
   {
      prcgethorariodisponibledoctor.this.aP4 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( short aP0 ,
                        java.util.Date aP1 ,
                        java.util.Date aP2 ,
                        String aP3 ,
                        GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( short aP0 ,
                             java.util.Date aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>[] aP4 )
   {
      prcgethorariodisponibledoctor.this.AV12ProfesionalId = aP0;
      prcgethorariodisponibledoctor.this.AV13DateFrom = aP1;
      prcgethorariodisponibledoctor.this.AV14DateTo = aP2;
      prcgethorariodisponibledoctor.this.AV15TipoDeCita = aP3;
      prcgethorariodisponibledoctor.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005N2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV12ProfesionalId), Gx_date, AV13DateFrom, AV14DateTo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A67DisponibilidadFecha = P005N2_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = P005N2_n67DisponibilidadFecha[0] ;
         A136DisponibilidadEstado = P005N2_A136DisponibilidadEstado[0] ;
         A31ProfesionalId = P005N2_A31ProfesionalId[0] ;
         A175ProfesionalNombreCompleto2 = P005N2_A175ProfesionalNombreCompleto2[0] ;
         A85ProfesionalApellidoPaterno = P005N2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P005N2_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P005N2_A84ProfesionalNombres[0] ;
         A175ProfesionalNombreCompleto2 = P005N2_A175ProfesionalNombreCompleto2[0] ;
         A85ProfesionalApellidoPaterno = P005N2_A85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = P005N2_A86ProfesionalApellidoMaterno[0] ;
         A84ProfesionalNombres = P005N2_A84ProfesionalNombres[0] ;
         AV8DetalleProfesional = (com.projectthani.SdtSDTHorariosDoctor)new com.projectthani.SdtSDTHorariosDoctor(remoteHandle, context);
         AV8DetalleProfesional.setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid( (short)(A31ProfesionalId) );
         AV8DetalleProfesional.setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombresapellidos( A175ProfesionalNombreCompleto2 );
         AV8DetalleProfesional.setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha( A67DisponibilidadFecha );
         AV8DetalleProfesional.setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornrodia( (short)(GXutil.day( A67DisponibilidadFecha)) );
         AV8DetalleProfesional.setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombremes( localUtil.cmonth( A67DisponibilidadFecha, "spa") );
         AV8DetalleProfesional.setgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctornombredia( localUtil.cdow( A67DisponibilidadFecha, "spa") );
         AV9HorarioDoctores.add(AV8DetalleProfesional, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV9HorarioDoctores.size() )
      {
         AV8DetalleProfesional = (com.projectthani.SdtSDTHorariosDoctor)((com.projectthani.SdtSDTHorariosDoctor)AV9HorarioDoctores.elementAt(-1+AV20GXV1));
         /* Using cursor P005N3 */
         pr_default.execute(1, new Object[] {Gx_date, AV15TipoDeCita, AV15TipoDeCita, Short.valueOf(AV8DetalleProfesional.getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorprofesionalid()), AV8DetalleProfesional.getgxTv_SdtSDTHorariosDoctor_Sdthorariosdoctorfecha()});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A31ProfesionalId = P005N3_A31ProfesionalId[0] ;
            A136DisponibilidadEstado = P005N3_A136DisponibilidadEstado[0] ;
            A67DisponibilidadFecha = P005N3_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = P005N3_n67DisponibilidadFecha[0] ;
            A298DisponibilidadTipoCita = P005N3_A298DisponibilidadTipoCita[0] ;
            A34DisponibilidadId = P005N3_A34DisponibilidadId[0] ;
            A135DisponibilidadHoraFin = P005N3_A135DisponibilidadHoraFin[0] ;
            n135DisponibilidadHoraFin = P005N3_n135DisponibilidadHoraFin[0] ;
            A139DisponibilidadEstadoCita = P005N3_A139DisponibilidadEstadoCita[0] ;
            A69DisponibilidadHoraInicio = P005N3_A69DisponibilidadHoraInicio[0] ;
            n69DisponibilidadHoraInicio = P005N3_n69DisponibilidadHoraInicio[0] ;
            AV11HorasProfesional = (com.projectthani.SdtSDTHorariosDoctor_DetalleItem)new com.projectthani.SdtSDTHorariosDoctor_DetalleItem(remoteHandle, context);
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalledisponibilidadid( A34DisponibilidadId );
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehora( localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")+" - "+localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ") );
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorainicio( A69DisponibilidadHoraInicio );
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallehorafin( A135DisponibilidadHoraFin );
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalletipocita( A298DisponibilidadTipoCita );
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecostocita( A199CostoConsulta );
            AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetalleestado( GXutil.charAt( A139DisponibilidadEstadoCita, 1) );
            if ( GXutil.strcmp(GXutil.charAt( A139DisponibilidadEstadoCita, 1), "L") == 0 )
            {
               AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor( "#42c0fb" );
               AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink( formatLink("com.projectthani.wpreservarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A34DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"})  );
            }
            if ( GXutil.strcmp(GXutil.charAt( A139DisponibilidadEstadoCita, 1), "O") == 0 )
            {
               AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallecolor( "#e9e9e9" );
               AV11HorasProfesional.setgxTv_SdtSDTHorariosDoctor_DetalleItem_Sdthorariosdoctordetallelink( "#" );
            }
            AV8DetalleProfesional.getgxTv_SdtSDTHorariosDoctor_Detalle().add(AV11HorasProfesional, 0);
            pr_default.readNext(1);
         }
         pr_default.close(1);
         AV10HorariosDoctores.add(AV8DetalleProfesional, 0);
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = prcgethorariodisponibledoctor.this.AV10HorariosDoctores;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10HorariosDoctores = new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>(com.projectthani.SdtSDTHorariosDoctor.class, "SDTHorariosDoctor", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      Gx_date = GXutil.nullDate() ;
      P005N2_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P005N2_n67DisponibilidadFecha = new boolean[] {false} ;
      P005N2_A136DisponibilidadEstado = new String[] {""} ;
      P005N2_A31ProfesionalId = new int[1] ;
      P005N2_A175ProfesionalNombreCompleto2 = new String[] {""} ;
      P005N2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      P005N2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P005N2_A84ProfesionalNombres = new String[] {""} ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A136DisponibilidadEstado = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      AV8DetalleProfesional = new com.projectthani.SdtSDTHorariosDoctor(remoteHandle, context);
      AV9HorarioDoctores = new GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>(com.projectthani.SdtSDTHorariosDoctor.class, "SDTHorariosDoctor", "ProjectThani", remoteHandle);
      P005N3_A31ProfesionalId = new int[1] ;
      P005N3_A136DisponibilidadEstado = new String[] {""} ;
      P005N3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P005N3_n67DisponibilidadFecha = new boolean[] {false} ;
      P005N3_A298DisponibilidadTipoCita = new String[] {""} ;
      P005N3_A34DisponibilidadId = new int[1] ;
      P005N3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      P005N3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      P005N3_A139DisponibilidadEstadoCita = new String[] {""} ;
      P005N3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      P005N3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      A298DisponibilidadTipoCita = "" ;
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A139DisponibilidadEstadoCita = "" ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV11HorasProfesional = new com.projectthani.SdtSDTHorariosDoctor_DetalleItem(remoteHandle, context);
      A199CostoConsulta = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgethorariodisponibledoctor__default(),
         new Object[] {
             new Object[] {
            P005N2_A67DisponibilidadFecha, P005N2_n67DisponibilidadFecha, P005N2_A136DisponibilidadEstado, P005N2_A31ProfesionalId, P005N2_A175ProfesionalNombreCompleto2, P005N2_A85ProfesionalApellidoPaterno, P005N2_A86ProfesionalApellidoMaterno, P005N2_A84ProfesionalNombres
            }
            , new Object[] {
            P005N3_A31ProfesionalId, P005N3_A136DisponibilidadEstado, P005N3_A67DisponibilidadFecha, P005N3_n67DisponibilidadFecha, P005N3_A298DisponibilidadTipoCita, P005N3_A34DisponibilidadId, P005N3_A135DisponibilidadHoraFin, P005N3_n135DisponibilidadHoraFin, P005N3_A139DisponibilidadEstadoCita, P005N3_A69DisponibilidadHoraInicio,
            P005N3_n69DisponibilidadHoraInicio
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short AV12ProfesionalId ;
   private short Gx_err ;
   private int A31ProfesionalId ;
   private int AV20GXV1 ;
   private int A34DisponibilidadId ;
   private java.math.BigDecimal A199CostoConsulta ;
   private String scmdbuf ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date AV13DateFrom ;
   private java.util.Date AV14DateTo ;
   private java.util.Date Gx_date ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean n67DisponibilidadFecha ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private String AV15TipoDeCita ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A139DisponibilidadEstadoCita ;
   private GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor>[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P005N2_A67DisponibilidadFecha ;
   private boolean[] P005N2_n67DisponibilidadFecha ;
   private String[] P005N2_A136DisponibilidadEstado ;
   private int[] P005N2_A31ProfesionalId ;
   private String[] P005N2_A175ProfesionalNombreCompleto2 ;
   private String[] P005N2_A85ProfesionalApellidoPaterno ;
   private String[] P005N2_A86ProfesionalApellidoMaterno ;
   private String[] P005N2_A84ProfesionalNombres ;
   private int[] P005N3_A31ProfesionalId ;
   private String[] P005N3_A136DisponibilidadEstado ;
   private java.util.Date[] P005N3_A67DisponibilidadFecha ;
   private boolean[] P005N3_n67DisponibilidadFecha ;
   private String[] P005N3_A298DisponibilidadTipoCita ;
   private int[] P005N3_A34DisponibilidadId ;
   private java.util.Date[] P005N3_A135DisponibilidadHoraFin ;
   private boolean[] P005N3_n135DisponibilidadHoraFin ;
   private String[] P005N3_A139DisponibilidadEstadoCita ;
   private java.util.Date[] P005N3_A69DisponibilidadHoraInicio ;
   private boolean[] P005N3_n69DisponibilidadHoraInicio ;
   private GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor> AV10HorariosDoctores ;
   private GXBaseCollection<com.projectthani.SdtSDTHorariosDoctor> AV9HorarioDoctores ;
   private com.projectthani.SdtSDTHorariosDoctor AV8DetalleProfesional ;
   private com.projectthani.SdtSDTHorariosDoctor_DetalleItem AV11HorasProfesional ;
}

final  class prcgethorariodisponibledoctor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005N2", "SELECT DISTINCT [DisponibilidadFecha], NULL AS [DisponibilidadEstado], [ProfesionalId], [ProfesionalNombreCompleto2], NULL AS [ProfesionalApellidoPaterno], NULL AS [ProfesionalApellidoMaterno], NULL AS [ProfesionalNombres] FROM ( SELECT TOP(100) PERCENT T1.[DisponibilidadFecha], T1.[DisponibilidadEstado], T1.[ProfesionalId], T2.[ProfesionalApellidoPaterno] + ' ' + T2.[ProfesionalApellidoMaterno] + ', ' + T2.[ProfesionalNombres] AS ProfesionalNombreCompleto2, T2.[ProfesionalApellidoPaterno], T2.[ProfesionalApellidoMaterno], T2.[ProfesionalNombres] FROM ([Disponibilidad] T1 INNER JOIN [Profesional] T2 ON T2.[ProfesionalId] = T1.[ProfesionalId]) WHERE (T1.[ProfesionalId] = ?) AND (T1.[DisponibilidadFecha] >= ?) AND (T1.[DisponibilidadFecha] >= ? and T1.[DisponibilidadFecha] <= ?) AND (T1.[DisponibilidadEstado] = 'A') ORDER BY T1.[ProfesionalId]) DistinctT ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P005N3", "SELECT [ProfesionalId], [DisponibilidadEstado], [DisponibilidadFecha], [DisponibilidadTipoCita], [DisponibilidadId], [DisponibilidadHoraFin], [DisponibilidadEstadoCita], [DisponibilidadHoraInicio] FROM [Disponibilidad] WHERE ([DisponibilidadFecha] >= ?) AND ((CHARINDEX(RTRIM([DisponibilidadTipoCita]), ?)) > 0 or (? = '')) AND ([ProfesionalId] = ?) AND ([DisponibilidadEstado] = 'A') AND ([DisponibilidadFecha] = ?) ORDER BY [DisponibilidadHoraInicio] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 1);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[6])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(8));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 40);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

