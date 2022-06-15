package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetprofesionalexperiencialaboral extends GXProcedure
{
   public prcgetprofesionalexperiencialaboral( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetprofesionalexperiencialaboral.class ), "" );
   }

   public prcgetprofesionalexperiencialaboral( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional> executeUdp( int aP0 )
   {
      prcgetprofesionalexperiencialaboral.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional>[] aP1 )
   {
      prcgetprofesionalexperiencialaboral.this.AV10ProfesionalId = aP0;
      prcgetprofesionalexperiencialaboral.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00712 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10ProfesionalId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31ProfesionalId = P00712_A31ProfesionalId[0] ;
         A56ExperienciaLaboralId = P00712_A56ExperienciaLaboralId[0] ;
         A204ExperienciaLaboralEmpresaNombre = P00712_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = P00712_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = P00712_A206ExperienciaLaboralHasta[0] ;
         AV8ExperienciaLaboral = (com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional)new com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional(remoteHandle, context);
         AV8ExperienciaLaboral.setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Id( A56ExperienciaLaboralId );
         AV8ExperienciaLaboral.setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa( A204ExperienciaLaboralEmpresaNombre );
         AV8ExperienciaLaboral.setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde( A205ExperienciaLaboralDesde );
         AV8ExperienciaLaboral.setgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta( A206ExperienciaLaboralHasta );
         AV9ListExperienciaLaboral.add(AV8ExperienciaLaboral, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = prcgetprofesionalexperiencialaboral.this.AV9ListExperienciaLaboral;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ListExperienciaLaboral = new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional>(com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional.class, "SDTProfesionalExperienciaLaboralProfesional", "ProjectThani", remoteHandle);
      scmdbuf = "" ;
      P00712_A31ProfesionalId = new int[1] ;
      P00712_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      P00712_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      P00712_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      P00712_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      A56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A204ExperienciaLaboralEmpresaNombre = "" ;
      A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      AV8ExperienciaLaboral = new com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcgetprofesionalexperiencialaboral__default(),
         new Object[] {
             new Object[] {
            P00712_A31ProfesionalId, P00712_A56ExperienciaLaboralId, P00712_A204ExperienciaLaboralEmpresaNombre, P00712_A205ExperienciaLaboralDesde, P00712_A206ExperienciaLaboralHasta
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10ProfesionalId ;
   private int A31ProfesionalId ;
   private String scmdbuf ;
   private java.util.Date A205ExperienciaLaboralDesde ;
   private java.util.Date A206ExperienciaLaboralHasta ;
   private String A204ExperienciaLaboralEmpresaNombre ;
   private java.util.UUID A56ExperienciaLaboralId ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00712_A31ProfesionalId ;
   private java.util.UUID[] P00712_A56ExperienciaLaboralId ;
   private String[] P00712_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] P00712_A205ExperienciaLaboralDesde ;
   private java.util.Date[] P00712_A206ExperienciaLaboralHasta ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional> AV9ListExperienciaLaboral ;
   private com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional AV8ExperienciaLaboral ;
}

final  class prcgetprofesionalexperiencialaboral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00712", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
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

