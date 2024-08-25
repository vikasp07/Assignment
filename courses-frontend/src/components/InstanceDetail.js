import React, { useEffect, useState } from "react";
import { getInstanceById } from "../services/courseService";
import { useParams } from "react-router-dom";

const InstanceDetail = () => {
  const { id } = useParams();
  const [instance, setInstance] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchInstance = async () => {
      try {
        const response = await getInstanceById(id);
        setInstance(response.data);
      } catch (error) {
        console.error("Error fetching instance details:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchInstance();
  }, [id]);

  if (loading) return <p>Loading...</p>;
  if (!instance) return <p>Instance not found</p>;

  return (
    <div>
      <h1>{instance.course.title}</h1>
      <p>
        <strong>Year:</strong> {instance.year}
      </p>
      <p>
        <strong>Semester:</strong> {instance.semester}
      </p>
    </div>
  );
};

export default InstanceDetail;
