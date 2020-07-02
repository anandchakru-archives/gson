package com.rathnas.main;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.rathnas.vo.Thing;
import com.rathnas.vo.sub.Animal;
import com.rathnas.vo.sub.Bird;
import com.rathnas.vo.sub.nested.Barking;
import com.rathnas.vo.sub.nested.Chirping;
import com.rathnas.vo.sub.nested.NoiseType;

public class GsonSerializer {
	public static void main(String[] args) {
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Thing.class, new ThingSerializer<Thing>()).registerTypeAdapter(NoiseType.class, new ThingSerializer<NoiseType>());
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		Animal thing = God.createDog();
		String tmp = gson.toJson(thing, Thing.class); // Note: StackoverflowError, if you do gson.toJson(thing)
		System.out.println("Ser Dog: " + tmp);
		System.out.println("Des Dog: " + gson.fromJson(tmp, Thing.class));
		Bird thing2 = God.createBird();
		tmp = gson.toJson(thing2, Thing.class);
		System.out.println("\n\n\nSer Bird: " + tmp);
		System.out.println("Des Bird: " + gson.fromJson(tmp, Thing.class));
	}
}

class ThingSerializer<T> implements JsonSerializer<T>, JsonDeserializer<T> {
	private static final String TYPE = "type";

	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObj = json.getAsJsonObject();
		String className = jsonObj.get(TYPE).getAsString();
		try {
			return context.deserialize(json, Class.forName(className));
		} catch (ClassNotFoundException e) {
			throw new JsonParseException(e);
		}
	}
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		JsonElement jsonEle = context.serialize(src, src.getClass());
		jsonEle.getAsJsonObject().addProperty(TYPE, src.getClass().getCanonicalName());
		return jsonEle;
	}
}

class God {
	public static Animal createDog() {
		Animal thing = new Animal();
		thing.setName("Dog");
		thing.setLegs(4);
		thing.setWings(0);
		thing.setNoise(new Barking());
		return thing;
	}
	public static Bird createBird() {
		Bird thing = new Bird();
		thing.setName("Bird");
		thing.setLegs(1);
		thing.setWings(2);
		thing.setNoise(new Chirping());
		return thing;
	}
}