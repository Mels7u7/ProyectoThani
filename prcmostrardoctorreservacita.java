package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcmostrardoctorreservacita extends GXProcedure
{
   public prcmostrardoctorreservacita( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcmostrardoctorreservacita.class ), "" );
   }

   public prcmostrardoctorreservacita( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita> executeUdp( short aP0 )
   {
      prcmostrardoctorreservacita.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>[] aP1 )
   {
      prcmostrardoctorreservacita.this.AV11ProfesionalId = aP0;
      prcmostrardoctorreservacita.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P005E3 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV11ProfesionalId), Short.valueOf(AV11ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P005E3_A31ProfesionalId[0] ;
         A40000ProfesionalFoto_GXI = P005E3_A40000ProfesionalFoto_GXI[0] ;
         A189ProfesionalFoto = P005E3_A189ProfesionalFoto[0] ;
         A183ProfesionalDireccion = P005E3_A183ProfesionalDireccion[0] ;
         A40001GXC2 = P005E3_A40001GXC2[0] ;
         n40001GXC2 = P005E3_n40001GXC2[0] ;
         A84ProfesionalNombres = P005E3_A84ProfesionalNombres[0] ;
         A86ProfesionalApellidoMaterno = P005E3_A86ProfesionalApellidoMaterno[0] ;
         A85ProfesionalApellidoPaterno = P005E3_A85ProfesionalApellidoPaterno[0] ;
         A40001GXC2 = P005E3_A40001GXC2[0] ;
         n40001GXC2 = P005E3_n40001GXC2[0] ;
         A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
         AV9DoctorReservarCita = (com.projectthani.SdtSDTDoctorReservarCita)new com.projectthani.SdtSDTDoctorReservarCita(remoteHandle, context);
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Profesionalid( A31ProfesionalId );
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Profesionalnombrecompleto( "<div class=\"\" style=\"margin-bottom: 2px;font-size: 15px;font-weight: bold;\"><span>"+A175ProfesionalNombreCompleto2+"</span></div>" );
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Profesionalfoto( A189ProfesionalFoto );
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Profesionalfoto_gxi( A40000ProfesionalFoto_GXI );
         GXt_char1 = "" ;
         GXv_char2[0] = GXt_char1 ;
         new com.projectthani.prcgetespecialidadbyprofesional(remoteHandle, context).execute( AV11ProfesionalId, GXv_char2) ;
         prcmostrardoctorreservacita.this.GXt_char1 = GXv_char2[0] ;
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Especialidadnombre( "<div style=\" font-size: 13px;font-weight: 500; margin-bottom: -13px;\"><span><i class=\"fas fa-briefcase-medical\" style=\"margin-right: 7px;\" ></i>"+GXt_char1+"</span><div>" );
         GXv_int3[0] = (byte)(AV12Rating) ;
         new com.projectthani.prccalcularratingporprofesional(remoteHandle, context).execute( AV11ProfesionalId, GXv_int3) ;
         prcmostrardoctorreservacita.this.AV12Rating = GXv_int3[0] ;
         AV13RatingHtml += "<div class=\"rating\" style=\"margin-top:-10px;\">" ;
         if ( AV12Rating == 0 )
         {
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
         }
         else if ( AV12Rating == 1 )
         {
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
         }
         else if ( AV12Rating == 2 )
         {
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
         }
         else if ( AV12Rating == 3 )
         {
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
         }
         else if ( AV12Rating == 4 )
         {
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star\" style=\"font-size: 13px;\"></i>" ;
         }
         else if ( AV12Rating == 5 )
         {
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
            AV13RatingHtml += "<i class=\"fas fa-star filled\" style=\"font-size: 13px;\"></i>" ;
         }
         AV14RatingNroRegistros = (short)(A40001GXC2) ;
         AV13RatingHtml += "<span class=\"d-inline-block average-rating\" style=\"font-size: 13px;\">(" + GXutil.str( AV14RatingNroRegistros, 4, 0) + ")</span>" ;
         AV13RatingHtml += "</div>" ;
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Calificacion( AV13RatingHtml );
         AV9DoctorReservarCita.setgxTv_SdtSDTDoctorReservarCita_Direccion( "<div style=\" font-size: 13px;font-weight: 500; margin-bottom: -13px;\"><span><i class=\"fas fa-map-marker-alt\" style=\"margin-right: 7px;\"></i>"+A183ProfesionalDireccion+"</span></div>" );
         AV10DoctorReservarCitas.add(AV9DoctorReservarCita, 0);
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcmostrardoctorreservacita.this.AV10DoctorReservarCitas;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10DoctorReservarCitas = new GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>(com.projectthani.SdtSDTDoctorReservarCita.class, "SDTDoctorReservarCita", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P005E3_A31ProfesionalId = new int[1] ;
      P005E3_A40000ProfesionalFoto_GXI = new String[] {""} ;
      P005E3_A189ProfesionalFoto = new String[] {""} ;
      P005E3_A183ProfesionalDireccion = new String[] {""} ;
      P005E3_A40001GXC2 = new int[1] ;
      P005E3_n40001GXC2 = new boolean[] {false} ;
      P005E3_A84ProfesionalNombres = new String[] {""} ;
      P005E3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      P005E3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      A40000ProfesionalFoto_GXI = "" ;
      A189ProfesionalFoto = "" ;
      A183ProfesionalDireccion = "" ;
      A84ProfesionalNombres = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      AV9DoctorReservarCita = new com.projectthani.SdtSDTDoctorReservarCita(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_int3 = new byte[1] ;
      AV13RatingHtml = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcmostrardoctorreservacita__default(),
         new Object[] {
             new Object[] {
            P005E3_A31ProfesionalId, P005E3_A40000ProfesionalFoto_GXI, P005E3_A189ProfesionalFoto, P005E3_A183ProfesionalDireccion, P005E3_A40001GXC2, P005E3_n40001GXC2, P005E3_A84ProfesionalNombres, P005E3_A86ProfesionalApellidoMaterno, P005E3_A85ProfesionalApellidoPaterno
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GXv_int3[] ;
   private short AV11ProfesionalId ;
   private short AV12Rating ;
   private short AV14RatingNroRegistros ;
   private short Gx_err ;
   private int A31ProfesionalId ;
   private int A40001GXC2 ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean n40001GXC2 ;
   private String AV13RatingHtml ;
   private String A40000ProfesionalFoto_GXI ;
   private String A183ProfesionalDireccion ;
   private String A84ProfesionalNombres ;
   private String A86ProfesionalApellidoMaterno ;
   private String A85ProfesionalApellidoPaterno ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A189ProfesionalFoto ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005E3_A31ProfesionalId ;
   private String[] P005E3_A40000ProfesionalFoto_GXI ;
   private String[] P005E3_A189ProfesionalFoto ;
   private String[] P005E3_A183ProfesionalDireccion ;
   private int[] P005E3_A40001GXC2 ;
   private boolean[] P005E3_n40001GXC2 ;
   private String[] P005E3_A84ProfesionalNombres ;
   private String[] P005E3_A86ProfesionalApellidoMaterno ;
   private String[] P005E3_A85ProfesionalApellidoPaterno ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctorReservarCita> AV10DoctorReservarCitas ;
   private com.projectthani.SdtSDTDoctorReservarCita AV9DoctorReservarCita ;
}

final  class prcmostrardoctorreservacita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005E3", "SELECT T1.[ProfesionalId], T1.[ProfesionalFoto_GXI], T1.[ProfesionalFoto], T1.[ProfesionalDireccion], COALESCE( T2.[GXC2], 0) AS GXC2, T1.[ProfesionalNombres], T1.[ProfesionalApellidoMaterno], T1.[ProfesionalApellidoPaterno] FROM ([Profesional] T1 LEFT JOIN (SELECT COUNT(*) AS GXC2, [SGProfesionalProfesionalId] FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? GROUP BY [SGProfesionalProfesionalId] ) T2 ON T2.[SGProfesionalProfesionalId] = T1.[ProfesionalId]) WHERE T1.[ProfesionalId] = ? ORDER BY T1.[ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaUri(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(2));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

