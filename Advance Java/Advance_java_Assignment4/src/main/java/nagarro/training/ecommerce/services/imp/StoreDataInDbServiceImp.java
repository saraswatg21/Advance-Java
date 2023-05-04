package nagarro.training.ecommerce.services.imp;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import nagarro.training.ecommerce.entities.AvailableType;
import nagarro.training.ecommerce.entities.GenderType;
import nagarro.training.ecommerce.entities.SizeType;
import nagarro.training.ecommerce.entities.Tshirt;
import nagarro.training.ecommerce.services.DbConnectionImp;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class StoreDataInDbServiceImp extends Thread {
	DbConnectionImp dbConnectionImp= new DbConnectionImp();
	File directory = new File("C:\\Govind saraswat\\govind-saraswat\\Assign4\\src\\main\\resources");

	public void run() {
		while (true) {
			Set<Tshirt> UpdatedStore = new HashSet<Tshirt>();
			for (String path : directory.list()) {
				String filepath = "C:\\Govind saraswat\\govind-saraswat\\Assign4\\src\\main\\resources";
				filepath += path;
				try {
					
					CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
					CSVReader reader = new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1)
							.withCSVParser(parser).build();
					String[] record;
					
					while ((record = reader.readNext()) != null) {
						Tshirt tshirt = new Tshirt(record[0], record[1], record[2], GenderType.valueOf(record[3]),
								SizeType.valueOf(record[4]), Double.parseDouble(record[5]),
								Double.parseDouble(record[6]), AvailableType.valueOf(record[7]));
						UpdatedStore.add(tshirt);

					}

				} catch (FileNotFoundException e) {
					System.out.println("Given File is not available");
				} catch (IOException e) {
					System.out.println("Inputs are wrong");
				} catch (CsvValidationException e) {
					System.out.println("Invalid");
				}
			}
			storeInDB(UpdatedStore);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void storeInDB(Set<Tshirt> updatedStore) {
		Session session = DbConnectionImp.getSessionFactory(Tshirt.class);
		Transaction transaction = session.beginTransaction();
		for (Tshirt item : updatedStore) {
			session.saveOrUpdate(item);
		}
		transaction.commit();
	}
}
