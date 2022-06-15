package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prccomentariosprofesional extends GXProcedure
{
   public prccomentariosprofesional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prccomentariosprofesional.class ), "" );
   }

   public prccomentariosprofesional( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional> executeUdp( int aP0 )
   {
      prccomentariosprofesional.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional>[] aP1 )
   {
      prccomentariosprofesional.this.AV10ProfesionalId = aP0;
      prccomentariosprofesional.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00832 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A62SGProfesionalProfesionalId = P00832_A62SGProfesionalProfesionalId[0] ;
         A63ComentarioProfesionalId = P00832_A63ComentarioProfesionalId[0] ;
         A61SGPacientePacienteId = P00832_A61SGPacientePacienteId[0] ;
         A384ComentarioProfesionalCitaId = P00832_A384ComentarioProfesionalCitaId[0] ;
         A385ComentarioProfesionalComentario = P00832_A385ComentarioProfesionalComentario[0] ;
         A386ComentarioProfesionalFechaRegistro = P00832_A386ComentarioProfesionalFechaRegistro[0] ;
         AV8ComentarioItem = (com.projectthani.SdtSDTComentariosProfesional)new com.projectthani.SdtSDTComentariosProfesional(remoteHandle, context);
         AV8ComentarioItem.setgxTv_SdtSDTComentariosProfesional_Comentarioid( A63ComentarioProfesionalId );
         AV8ComentarioItem.setgxTv_SdtSDTComentariosProfesional_Pacienteid( A61SGPacientePacienteId );
         AV8ComentarioItem.setgxTv_SdtSDTComentariosProfesional_Profesionalid( A62SGProfesionalProfesionalId );
         AV8ComentarioItem.setgxTv_SdtSDTComentariosProfesional_Citaid( A384ComentarioProfesionalCitaId );
         AV8ComentarioItem.setgxTv_SdtSDTComentariosProfesional_Comentario( A385ComentarioProfesionalComentario );
         AV8ComentarioItem.setgxTv_SdtSDTComentariosProfesional_Fecharegistro( A386ComentarioProfesionalFechaRegistro );
         AV9ComentarioList.add(AV8ComentarioItem, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prccomentariosprofesional.this.AV9ComentarioList;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ComentarioList = new GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional>(com.projectthani.SdtSDTComentariosProfesional.class, "SDTComentariosProfesional", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P00832_A62SGProfesionalProfesionalId = new int[1] ;
      P00832_A63ComentarioProfesionalId = new int[1] ;
      P00832_A61SGPacientePacienteId = new int[1] ;
      P00832_A384ComentarioProfesionalCitaId = new short[1] ;
      P00832_A385ComentarioProfesionalComentario = new String[] {""} ;
      P00832_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      A385ComentarioProfesionalComentario = "" ;
      A386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      AV8ComentarioItem = new com.projectthani.SdtSDTComentariosProfesional(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prccomentariosprofesional__default(),
         new Object[] {
             new Object[] {
            P00832_A62SGProfesionalProfesionalId, P00832_A63ComentarioProfesionalId, P00832_A61SGPacientePacienteId, P00832_A384ComentarioProfesionalCitaId, P00832_A385ComentarioProfesionalComentario, P00832_A386ComentarioProfesionalFechaRegistro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A384ComentarioProfesionalCitaId ;
   private short Gx_err ;
   private int AV10ProfesionalId ;
   private int A62SGProfesionalProfesionalId ;
   private int A63ComentarioProfesionalId ;
   private int A61SGPacientePacienteId ;
   private String scmdbuf ;
   private java.util.Date A386ComentarioProfesionalFechaRegistro ;
   private String A385ComentarioProfesionalComentario ;
   private GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00832_A62SGProfesionalProfesionalId ;
   private int[] P00832_A63ComentarioProfesionalId ;
   private int[] P00832_A61SGPacientePacienteId ;
   private short[] P00832_A384ComentarioProfesionalCitaId ;
   private String[] P00832_A385ComentarioProfesionalComentario ;
   private java.util.Date[] P00832_A386ComentarioProfesionalFechaRegistro ;
   private GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional> AV9ComentarioList ;
   private com.projectthani.SdtSDTComentariosProfesional AV8ComentarioItem ;
}

final  class prccomentariosprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00832", "SELECT [SGProfesionalProfesionalId], [ComentarioProfesionalId], [SGPacientePacienteId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro] FROM [ComentarioProfesional] WHERE [SGProfesionalProfesionalId] = ? ORDER BY [SGProfesionalProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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

