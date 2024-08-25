import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

// Course endpoints
export const getCourses = async () => {
  try {
    return await axios.get(`${API_BASE_URL}/courses`);
  } catch (error) {
    console.error("Error fetching courses:", error.response || error.message);
    throw error;
  }
};

export const getCourseById = async (id) => {
  try {
    return await axios.get(`${API_BASE_URL}/courses/${id}`);
  } catch (error) {
    console.error(
      "Error fetching course by ID:",
      error.response || error.message
    );
    throw error;
  }
};

export const createCourse = async (courseData) => {
  try {
    return await axios.post(`${API_BASE_URL}/courses`, courseData);
  } catch (error) {
    console.error("Error creating course:", error.response || error.message);
    throw error;
  }
};

export const deleteCourse = async (id) => {
  try {
    return await axios.delete(`${API_BASE_URL}/courses/${id}`);
  } catch (error) {
    console.error("Error deleting course:", error.response || error.message);
    throw error;
  }
};

// Course Instance endpoints
export const getInstances = async () => {
  try {
    return await axios.get(`${API_BASE_URL}/instances`);
  } catch (error) {
    console.error("Error fetching instances:", error.response || error.message);
    throw error;
  }
};

export const getInstanceById = async (id) => {
  try {
    return await axios.get(`${API_BASE_URL}/instances/${id}`);
  } catch (error) {
    console.error(
      "Error fetching instance by ID:",
      error.response || error.message
    );
    throw error;
  }
};

export const createInstance = async (instanceData) => {
  try {
    return await axios.post(`${API_BASE_URL}/instances`, instanceData);
  } catch (error) {
    console.error("Error creating instance:", error.response || error.message);
    throw error;
  }
};
