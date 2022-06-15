package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcinsertprofesionalespecialidad extends GXProcedure
{
   public prcinsertprofesionalespecialidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcinsertprofesionalespecialidad.class ), "" );
   }

   public prcinsertprofesionalespecialidad( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        java.math.BigDecimal aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             java.math.BigDecimal aP4 )
   {
      prcinsertprofesionalespecialidad.this.AV8ProfesionalId = aP0;
      prcinsertprofesionalespecialidad.this.AV12EspecialidadId = aP1;
      prcinsertprofesionalespecialidad.this.AV9SedeId = aP2;
      prcinsertprofesionalespecialidad.this.AV10SedeTipoConsulta = aP3;
      prcinsertprofesionalespecialidad.this.AV11CostoConsulta = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE ProfesionalEspecialidad

      */
      A31ProfesionalId = AV8ProfesionalId ;
      A32EspecialidadId = AV12EspecialidadId ;
      /* Using cursor P007J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidad");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      /*
         INSERT RECORD ON TABLE ProfesionalEspecialidadSede

      */
      A31ProfesionalId = AV8ProfesionalId ;
      A32EspecialidadId = AV12EspecialidadId ;
      A30SedeId = AV9SedeId ;
      A54SedeTipoConsulta = AV10SedeTipoConsulta ;
      A199CostoConsulta = DecimalUtil.doubleToDec(0) ;
      /* Using cursor P007J3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta, A199CostoConsulta});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
      if ( (pr_default.getStatus(1) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "prcinsertprofesionalespecialidad");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gx_emsg = "" ;
      A54SedeTipoConsulta = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcinsertprofesionalespecialidad__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EspecialidadId ;
   private short AV9SedeId ;
   private short A32EspecialidadId ;
   private short Gx_err ;
   private short A30SedeId ;
   private int AV8ProfesionalId ;
   private int GX_INS10 ;
   private int A31ProfesionalId ;
   private int GX_INS11 ;
   private java.math.BigDecimal AV11CostoConsulta ;
   private java.math.BigDecimal A199CostoConsulta ;
   private String AV10SedeTipoConsulta ;
   private String Gx_emsg ;
   private String A54SedeTipoConsulta ;
   private IDataStoreProvider pr_default ;
}

final  class prcinsertprofesionalespecialidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P007J2", "INSERT INTO [ProfesionalEspecialidad]([ProfesionalId], [EspecialidadId]) VALUES(?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P007J3", "INSERT INTO [ProfesionalEspecialidadSede]([ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta], [CostoConsulta]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               return;
      }
   }

}

