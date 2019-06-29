package com.company;

import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {
	public static Boolean canViewAll(Collection<Movie> movies) {
		ArrayList<Movie> realMovies = new ArrayList<>(movies);
		Collections.sort(realMovies);
		for (int i = 0 ; i < realMovies.size()-1; i++) {
			Movie movie1 = realMovies.get(i);
			Movie movie2 = realMovies.get(i+1);
			if (movie1.getEnd().after(movie2.getStart()))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
		movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
		movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

		System.out.println(MovieNight.canViewAll(movies));
	}
}

class Movie implements Comparable<Movie>{
	private Date start, end;

	public Movie(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return this.start;
	}

	public Date getEnd() {
		return this.end;
	}

	@Override
	public int compareTo(Movie movie) {
		return this.getStart().compareTo(movie.getStart());
	}
}