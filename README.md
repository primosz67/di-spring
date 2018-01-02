# di-spring
DI with Spring annotations -  for Android and Desktop


### Spring Beans Scan ####


```java 
final BeanScanner scanner = new BeanScanner(
    "com.android.example",
    "com.android.some.other"
    ...
);
scanner.addDefinitions(SpringConfiguration.scannerDefinitions());
scanner.addDefinitions(JavaConfiguration.scannerDefinitions()); //for @Inject annotation
scanner.addDefinition(new SimpleScannerDefinition<>(Controller.class, x -> null));  // Custome @Controller annotation

final Injector injector = new Injector();
injector.addDefinitions(SpringConfiguration.injectDefinitions());

injector.registerAll(scanner.scan());

//if some additional class needed
injector.register(FromOutsideOfPackage.class);

container = new BeanContainer(injector);
container.initialize();

```

## Service example ##

```java
@Service
class ExampleService {

	@Autowired // or @Inject
 	private SomeOtherService service;

}
```

## Constructor injection ##

```java
@Component
class ExampleService {

	private SomeOtherService service;

	//constructor injection without annotation - same behaviour as Spring 5  
	public ExampleService (SomeOtherServiceInterface service ) {
		this.service = service
	}
}
```