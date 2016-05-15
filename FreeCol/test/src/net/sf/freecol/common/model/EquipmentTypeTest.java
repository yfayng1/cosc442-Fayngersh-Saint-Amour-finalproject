package net.sf.freecol.common.model;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import net.sf.freecol.common.io.FreeColXMLWriter;
import javax.xml.stream.XMLStreamException;
import net.sf.freecol.common.io.FreeColXMLReader;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>EquipmentTypeTest</code> contains tests for the class <code>{@link EquipmentType}</code>.
 *
 * @generatedBy CodePro at 5/14/16 11:14 PM
 * @author FIRMS
 * @version $Revision: 1.0 $
 */
public class EquipmentTypeTest {
	/**
	 * Run the EquipmentType(String,Specification) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquipmentType_1()
		throws Exception {
		String id = "";
		Specification specification = new Specification();

		EquipmentType result = new EquipmentType(id, specification);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRole());
		assertEquals(false, result.isMilitaryEquipment());
		assertEquals(-1, result.getCombatLossPriority());
		assertEquals(1, result.getMaximumCount());
		assertEquals("equipment-type", result.getXMLTagName());
		assertEquals(1, result.getRequiredPopulation());
		assertEquals(false, result.needsGoodsToBuild());
		assertEquals("", result.toString());
		assertEquals(".description", result.getDescriptionKey());
		assertEquals(".name", result.getNameKey());
		assertEquals(false, result.isAbstractType());
		assertEquals("", result.getId());
		assertEquals("", result.getSuffix());
		assertEquals(null, result.getGame());
		assertEquals("", result.getIdType());
		assertEquals(-1, result.getIdNumber());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		EquipmentType obj = new EquipmentType("", new Specification());
		obj.setRole(new Role("", new Specification()));

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Object obj = new EquipmentType("", new Specification());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Object obj = new EquipmentType("", new Specification());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Object obj = new EquipmentType("", new Specification());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Object obj = new EquipmentType("", new Specification());

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int getCombatLossPriority() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testGetCombatLossPriority_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		int result = fixture.getCombatLossPriority();

		// add additional test code here
		assertEquals(-1, result);
	}

	/**
	 * Run the int getMaximumCount() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testGetMaximumCount_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		int result = fixture.getMaximumCount();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the Role getRole() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testGetRole_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		Role result = fixture.getRole();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getMaximumCount());
		assertEquals("role", result.getXMLTagName());
		assertEquals(false, result.isOffensive());
		assertEquals(null, result.getDowngrade());
		assertEquals(false, result.isDefaultRole());
		assertEquals("", result.getRoleSuffix());
		assertEquals(0.0, result.getOffence(), 1.0);
		assertEquals(null, result.getExpertUnit());
		assertEquals(false, result.isDefensive());
		assertEquals("[Role ]", result.toFullString());
		assertEquals(1, result.getRequiredPopulation());
		assertEquals(false, result.needsGoodsToBuild());
		assertEquals("", result.toString());
		assertEquals(".description", result.getDescriptionKey());
		assertEquals(".name", result.getNameKey());
		assertEquals(false, result.isAbstractType());
		assertEquals("", result.getId());
		assertEquals("", result.getSuffix());
		assertEquals(null, result.getGame());
		assertEquals("", result.getIdType());
		assertEquals(-1, result.getIdNumber());
	}

	/**
	 * Run the String getTagName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testGetTagName_1()
		throws Exception {

		String result = EquipmentType.getTagName();

		// add additional test code here
		assertEquals("equipment-type", result);
	}

	/**
	 * Run the String getXMLTagName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testGetXMLTagName_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		String result = fixture.getXMLTagName();

		// add additional test code here
		assertEquals("equipment-type", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1369, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(1369, result);
	}

	/**
	 * Run the boolean isMilitaryEquipment() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testIsMilitaryEquipment_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		boolean result = fixture.isMilitaryEquipment();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isMilitaryEquipment() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testIsMilitaryEquipment_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));

		boolean result = fixture.isMilitaryEquipment();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void readAttributes(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadAttributes_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readAttributes(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.getAttribute(FreeColXMLReader.java:394)
		//       at net.sf.freecol.common.io.FreeColXMLReader.readId(FreeColXMLReader.java:236)
		//       at net.sf.freecol.common.model.FreeColObject.readAttributes(FreeColObject.java:1127)
		//       at net.sf.freecol.common.model.FreeColSpecObjectType.readAttributes(FreeColSpecObjectType.java:214)
		//       at net.sf.freecol.common.model.BuildableType.readAttributes(BuildableType.java:285)
		//       at net.sf.freecol.common.model.EquipmentType.readAttributes(EquipmentType.java:288)
	}

	/**
	 * Run the void readAttributes(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadAttributes_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readAttributes(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.getAttribute(FreeColXMLReader.java:394)
		//       at net.sf.freecol.common.io.FreeColXMLReader.readId(FreeColXMLReader.java:236)
		//       at net.sf.freecol.common.model.FreeColObject.readAttributes(FreeColObject.java:1127)
		//       at net.sf.freecol.common.model.FreeColSpecObjectType.readAttributes(FreeColSpecObjectType.java:214)
		//       at net.sf.freecol.common.model.BuildableType.readAttributes(BuildableType.java:285)
		//       at net.sf.freecol.common.model.EquipmentType.readAttributes(EquipmentType.java:288)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_3()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_4()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_5()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_6()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_7()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChild(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChild_8()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChild(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Method getLocalName() cannot be called for START_DOCUMENT event.
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getLocalName(Unknown Source)
		//       at javax.xml.stream.util.StreamReaderDelegate.getLocalName(Unknown Source)
		//       at net.sf.freecol.common.model.EquipmentType.readChild(EquipmentType.java:327)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_3()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_4()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_5()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_6()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_7()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_8()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void readChildren(FreeColXMLReader) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testReadChildren_9()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLReader xr = new FreeColXMLReader(new BufferedInputStream(new ByteArrayInputStream("".getBytes())));

		fixture.readChildren(xr);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalStateException: Current state is not among the states START_ELEMENT , ATTRIBUTEvalid for getAttributeValue()
		//       at com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl.getAttributeValue(Unknown Source)
		//       at net.sf.freecol.common.io.FreeColXMLReader.hasAttribute(FreeColXMLReader.java:306)
		//       at net.sf.freecol.common.io.FreeColXMLReader.shouldClearContainers(FreeColXMLReader.java:850)
		//       at net.sf.freecol.common.model.EquipmentType.readChildren(EquipmentType.java:304)
	}

	/**
	 * Run the void setRole(Role) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testSetRole_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		Role role = new Role("", new Specification());

		fixture.setRole(role);

		// add additional test code here
	}

	/**
	 * Run the void writeAttributes(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test(expected = javax.xml.stream.XMLStreamException.class)
	public void testWriteAttributes_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeAttributes(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeAttributes(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test(expected = javax.xml.stream.XMLStreamException.class)
	public void testWriteAttributes_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeAttributes(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeAttributes(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test(expected = javax.xml.stream.XMLStreamException.class)
	public void testWriteAttributes_3()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeAttributes(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeAttributes(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test(expected = javax.xml.stream.XMLStreamException.class)
	public void testWriteAttributes_4()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeAttributes(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeAttributes(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test(expected = javax.xml.stream.XMLStreamException.class)
	public void testWriteAttributes_5()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeAttributes(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_1()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_2()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_3()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_4()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_5()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_6()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_7()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_8()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_9()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_10()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_11()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_12()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_13()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Run the void writeChildren(FreeColXMLWriter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Test
	public void testWriteChildren_14()
		throws Exception {
		EquipmentType fixture = new EquipmentType("", new Specification());
		fixture.setRole(new Role("", new Specification()));
		FreeColXMLWriter xw = new FreeColXMLWriter(new StringWriter(), net.sf.freecol.common.io.FreeColXMLWriter.WriteScope.CLIENT);

		fixture.writeChildren(xw);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 5/14/16 11:14 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(EquipmentTypeTest.class);
	}
}