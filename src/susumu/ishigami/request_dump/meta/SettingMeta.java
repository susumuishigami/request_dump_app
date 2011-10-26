package susumu.ishigami.request_dump.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-10-23 16:27:44")
/** */
public final class SettingMeta extends org.slim3.datastore.ModelMeta<susumu.ishigami.request_dump.model.Setting> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.Setting, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.Setting, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.Setting, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.Setting, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.Setting> responseLines = new org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.Setting>(this, "responseLines", "responseLines");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.Setting, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.Setting, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SettingMeta slim3_singleton = new SettingMeta();

    /**
     * @return the singleton
     */
    public static SettingMeta get() {
       return slim3_singleton;
    }

    /** */
    public SettingMeta() {
        super("Setting", susumu.ishigami.request_dump.model.Setting.class);
    }

    @Override
    public susumu.ishigami.request_dump.model.Setting entityToModel(com.google.appengine.api.datastore.Entity entity) {
        susumu.ishigami.request_dump.model.Setting model = new susumu.ishigami.request_dump.model.Setting();
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setKey(entity.getKey());
        model.setResponseLines(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("responseLines")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        susumu.ishigami.request_dump.model.Setting m = (susumu.ishigami.request_dump.model.Setting) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setUnindexedProperty("responseLines", stringToText(m.getResponseLines()));
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        susumu.ishigami.request_dump.model.Setting m = (susumu.ishigami.request_dump.model.Setting) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        susumu.ishigami.request_dump.model.Setting m = (susumu.ishigami.request_dump.model.Setting) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        susumu.ishigami.request_dump.model.Setting m = (susumu.ishigami.request_dump.model.Setting) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void incrementVersion(Object model) {
        susumu.ishigami.request_dump.model.Setting m = (susumu.ishigami.request_dump.model.Setting) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        assignKeyIfNecessary(model);
        incrementVersion(model);
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

}